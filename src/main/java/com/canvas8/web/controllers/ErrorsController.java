package com.canvas8.web.controllers;

import com.canvas8.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mrnimelo on 02/05/17.
 */
@Controller
public class ErrorsController {
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView("403");
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addObject("roles", user.getRoles());
        } catch (Throwable t) {
            model.addObject("msg", "You do not have permission to access this page!");
        }
        finally {
            return model;
        }
    }
}
