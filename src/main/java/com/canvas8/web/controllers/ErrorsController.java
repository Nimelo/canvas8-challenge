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
public class ErrorsController {
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("roles", user.getRoles());
        } else {
            model.addObject("msg","You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;

    }
}
