package com.canvas8.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mrnimelo on 02/05/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String registration() {
        return "admin-settings";
    }
}
