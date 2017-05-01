package com.canvas8.web.controllers;

import com.canvas8.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mrnimelo on 02/05/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView model = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("roles", user.getRoles());
        model.setViewName("admin-settings");
        return model;
    }
}
