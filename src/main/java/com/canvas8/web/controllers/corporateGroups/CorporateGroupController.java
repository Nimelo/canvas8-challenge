package com.canvas8.web.controllers.corporateGroups;

import com.canvas8.models.CorporateGroup;
import com.canvas8.repositories.CorporateGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("corporate-groups/list");

        List<CorporateGroup> all = corporateGroupRepository.findAll();
        modelAndView.addObject("corporateGroups", all);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        if(corporateGroupRepository.exists(id)){
            corporateGroupRepository.delete(id);
        }

        return "redirect:corporate-groups/list";
    }

    @RequestMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("corporate-groups/add");

        modelAndView.addObject("corporateGroup", new CorporateGroup());

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("corporate-groups/edit");

        CorporateGroup corporateGroup = corporateGroupRepository.getOne(id);
        modelAndView.addObject("corporateGroup", corporateGroup);

        return modelAndView;
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("corporate-groups/view");

        CorporateGroup corporateGroup = corporateGroupRepository.getOne(id);
        modelAndView.addObject("corporateGroup", corporateGroup);

        return modelAndView;
    }
}
