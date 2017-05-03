package com.canvas8.web.controllers;

import com.canvas8.models.CorporateGroup;
import com.canvas8.models.User;
import com.canvas8.services.corporateGroups.CorporateGroupService;
import com.canvas8.services.user.UserService;
import com.canvas8.validators.AuthenticationValidator;
import com.canvas8.validators.UserValidator;
import com.canvas8.web.controllers.internal.models.UserSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private AuthenticationValidator authenticationValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private CorporateGroupService corporateGroupService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam(value = "userId") Integer userId) {
        userService.remove(userId);
    }

    @RequestMapping(value = "/add-edit")
    public String addedit(Model model, @RequestParam(value = "id", required = false) Integer id, HttpSession session) {
        User user = id == null ? new User() : userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("editMode", id != null);

        return "users/add-edit";
    }

    @RequestMapping(value = "/add-edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (user != null && user.getId() != 0) {
            User dbUser = userService.findById(user.getId());
            user.setPassword(dbUser.getPassword());
        }
        userValidator.validate(user, bindingResult);
        if (user.getId() == 0) {
            authenticationValidator.validate(user, bindingResult);
        }

        CorporateGroup corporateGroup = (CorporateGroup) session.getAttribute("corporateGroup");
        user.setCorporateGroup(corporateGroup);

        if (bindingResult.hasErrors()) {
            return "users/add-edit";
        }

        userService.save(user);

        return "redirect:/corporate-groups/" + corporateGroup.getId() + "/view";
    }

    @RequestMapping(value = "/search")
    public String search(Model model) {
        List<CorporateGroup> corporateGroups = corporateGroupService.findAll();
        model.addAttribute("searchQuery", new UserSearchModel());
        model.addAttribute("corporateGroups", corporateGroups);

        return "users/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("searchQuery") UserSearchModel userSearchModel, Model model) {

        List<User> result = userService.findByFirstNameAndSecondNameAndEmailAndCorporateGroupId(
                userSearchModel.getFirstName(),
                userSearchModel.getSecondName(),
                userSearchModel.getEmail(),
                userSearchModel.getCorporateGroupId());
        List<CorporateGroup> corporateGroups = corporateGroupService.findAll();

        model.addAttribute("searchQuery", userSearchModel);
        model.addAttribute("corporateGroups", corporateGroups);
        model.addAttribute("users", result);
        return "users/search";
    }
}
