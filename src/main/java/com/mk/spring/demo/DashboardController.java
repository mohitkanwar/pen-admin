package com.mk.spring.demo;

import com.mk.pen.blog.BlogCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
    @Autowired
    private BlogCRUDController blogCRUDController;
    @RequestMapping(value = {"/", "/dashboard"})
    public ModelAndView dashboard() {
        return new ModelAndView("dashboard", "blogList", blogCRUDController.retrieveBlogs());
    }
}