package com.canvas8.web.controllers.corporateGroups;

import com.canvas8.models.CorporateGroup;
import com.canvas8.repositories.CorporateGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mrnimelo on 02/05/17.
 */
@Controller
@RequestMapping(value = "/corporate-groups")
public class CorporateGroupController {

    @Autowired
    CorporateGroupRepository corporateGroupRepository;

    @RequestMapping(value = "/list")
    public ModelAndView getCorporateGroups() {
        ModelAndView modelAndView = new ModelAndView("lists/corporate-group-list");

        List<CorporateGroup> all = corporateGroupRepository.findAll();
        modelAndView.addObject("corporateGroups", all);

        return modelAndView;
    }
}
