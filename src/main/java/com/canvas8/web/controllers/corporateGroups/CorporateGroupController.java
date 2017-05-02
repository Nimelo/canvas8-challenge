package com.canvas8.web.controllers.corporateGroups;

import com.canvas8.models.CorporateGroup;
import com.canvas8.repositories.CorporateGroupRepository;
import com.canvas8.validators.CorporateGroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    CorporateGroupValidator corporateGroupValidator;

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

        return "redirect:/corporate-groups/list";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("corporateGroup", new CorporateGroup());
        return "corporate-groups/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("corporateGroup") CorporateGroup corporateGroup, BindingResult bindingResult, Model model) {
        corporateGroupValidator.validate(corporateGroup, bindingResult);

        if(bindingResult.hasErrors()){
            return "corporate-groups/add";
        }

        corporateGroupRepository.save(corporateGroup);

        return "redirect:/corporate-groups/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id, Model model) {

        CorporateGroup corporateGroup = corporateGroupRepository.findOne(id);
        model.addAttribute("corporateGroup", corporateGroup);

        return "corporate-groups/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute("corporateGroup") CorporateGroup corporateGroup, BindingResult bindingResult, Model model) {
        corporateGroupValidator.validate(corporateGroup, bindingResult);

        if(bindingResult.hasErrors()){
            return "corporate-groups/edit";
        }

        corporateGroupRepository.save(corporateGroup);

        return "redirect:/corporate-groups/list";
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("corporate-groups/view");

        CorporateGroup corporateGroup = corporateGroupRepository.getOne(id);
        modelAndView.addObject("corporateGroup", corporateGroup);

        return modelAndView;
    }
}
