package com.canvas8.validators;

import com.canvas8.models.User;
import com.canvas8.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (!emailValidator.validate(user.getEmail())) {
            errors.rejectValue("email", "Email.format");
        }

        if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email");
        }

        User dbUserEmail = userService.findByUsername(user.getEmail());
        if (dbUserEmail != null &&
                dbUserEmail.getId() != user.getId())
            errors.rejectValue("email", "Duplicate.userForm.email");
    }
}
