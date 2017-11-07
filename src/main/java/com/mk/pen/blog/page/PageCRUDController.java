package com.mk.pen.blog.page;

import com.mk.pen.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;


@Controller
public class PageCRUDController {

    @Autowired
    private PageCRUDService service;

    @RequestMapping(value = {"/blog/{blogId}/page/create"} ,method = {RequestMethod.POST})
    public @ResponseBody  String createPage(@RequestParam(value = "blogId", required = true) String blogId,
                                            @RequestParam(value = "pageTitle", required = true) String pageTitle ){
        System.out.println("Inside blog create!!!!");


       String msg;
        try {


          throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
            msg = "Blog Creation Failed";
        }
        return "{\"msg\":\""+msg+"\"}";
    }



    @RequestMapping(value = {"/blog/{blogId}/pages/{pageId}update"},method = {RequestMethod.PUT})
    public @ResponseBody  String updateBlog(){
        return "{\"msg\":\"Blog update Successfull\"}";
    }
    @RequestMapping(value = {"/blog/{blogId}/pages"},method = {RequestMethod.GET}, produces = "application/json")
    public @ResponseBody  List<Blog> retrieveBlogs(){
        return service.getBlogs();
    }

    @RequestMapping(value = {"/blog/{blogId}/pages/{pageId}delete"},method = {RequestMethod.DELETE})
    public @ResponseBody  String deleteBlog(){
        return "{\"msg\":\"Blog delete Successfull\"}";
    }
}
