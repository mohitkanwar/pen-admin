package com.mk.pen.roles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mkanwar on 06/09/17.
 */
@Controller
public class RoleController {
    private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService service;

    @RequestMapping(value = "/roles", method = {RequestMethod.GET})
    public String getRoles(Model model) {
        model.addAttribute("roleList",service.getRolesList());
        return "roles";

    }
}
