package com.canvas8.web.controllers;

import com.canvas8.models.CorporateGroup;
import com.canvas8.models.User;
import com.canvas8.services.UserService;
import com.canvas8.services.corporateGroups.CorporateGroupServiceImpl;
import com.canvas8.validators.CorporateGroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
@RequestMapping(value = "/corporate-groups")
public class CorporateGroupController {
    private static Integer MAX_PAGING_SIZE_FOR_USERS = 10;

    @Autowired
    CorporateGroupServiceImpl corporateGroupService;

    @Autowired
    UserService userService;

    @Autowired
    CorporateGroupValidator corporateGroupValidator;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("corporate-groups/list");

        List<CorporateGroup> all = corporateGroupService.findAll();
        modelAndView.addObject("corporateGroups", all);

        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable(value = "id") Integer id) {
        corporateGroupService.deleteIfExist(id);

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

        if (bindingResult.hasErrors()) {
            return "corporate-groups/add";
        }

        corporateGroupService.save(corporateGroup);

        return "redirect:/corporate-groups/list";
    }

    @RequestMapping(value = "/{id}/edit")
    public String edit(@PathVariable(value = "id") Integer id, Model model) {

        CorporateGroup corporateGroup = corporateGroupService.findOne(id);
        model.addAttribute("corporateGroup", corporateGroup);

        return "corporate-groups/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute("corporateGroup") CorporateGroup corporateGroup, BindingResult bindingResult, Model model) {
        corporateGroupValidator.validate(corporateGroup, bindingResult);

        if (bindingResult.hasErrors()) {
            return "corporate-groups/edit";
        }

        corporateGroupService.save(corporateGroup);

        return "redirect:/corporate-groups/list";
    }

    @RequestMapping(value = "/{id}/view")
    public String view(@PathVariable(value = "id") Integer id, Model model, Pageable pageable) {

        CorporateGroup corporateGroup = corporateGroupService.findOne(id);

        PageRequest adjustedPagable = new PageRequest(pageable.getPageNumber(), MAX_PAGING_SIZE_FOR_USERS, pageable.getSort());
        Page<User> users = userService.findByCorporateGroupId(corporateGroup, adjustedPagable);
        model.addAttribute("corporateGroup", corporateGroup);
        model.addAttribute("users", users);
        model.addAttribute("pageNumber", adjustedPagable.getPageNumber());
        model.addAttribute("endIndex", users.getTotalPages() - 1);

        return "corporate-groups/view";
    }
}
