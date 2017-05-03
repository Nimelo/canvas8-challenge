package com.canvas8.validators;

import com.canvas8.models.CorporateGroup;
import com.canvas8.repositories.CorporateGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by mrnimelo on 02/05/17.
 */
@Component
public class CorporateGroupValidator implements Validator {
    @Autowired
    CorporateGroupRepository corporateGroupRepository;

    @Autowired
    EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return CorporateGroup.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CorporateGroup corporateGroup = (CorporateGroup) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        CorporateGroup dbGroup = corporateGroupRepository.findByName(corporateGroup.getName());
        if (dbGroup != null) {
            if (dbGroup.getId() != corporateGroup.getId()) {
                errors.rejectValue("name", "Duplicate.corporateGroupForm.name");
            }
        }

        if (corporateGroup.getEmail() != null && !corporateGroup.getEmail().isEmpty()) {
            if (!emailValidator.validate(corporateGroup.getEmail())) {
                errors.rejectValue("email", "Email.format");
            }
        }
    }
}
