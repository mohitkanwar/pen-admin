package com.mk.pen.blog;

import com.mk.pen.domain.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BlogCRUDController {

    @Autowired
    private BlogCRUDService service;

    @RequestMapping(value = {"/blog/create"} ,method = {RequestMethod.POST})
    public @ResponseBody  String createBlog(@RequestParam(value = "blogTitle", required = true) String blogTitle,
                                            @RequestParam(value = "blogDescription", required = false) String blogDescription ){
        System.out.println("Inside blog create!!!!");


       String msg;
        try {

            Blog blog = new Blog();
            blog.setTitle(blogTitle);
            blog.setDescription(blogDescription);
            msg = service.createBlog(blog);
        } catch (IOException e) {
            e.printStackTrace();
            msg = "Blog Creation Failed";
        }
        return "{\"msg\":\""+msg+"\"}";
    }



    @RequestMapping(value = {"/blog/update"},method = {RequestMethod.PUT})
    public @ResponseBody  String updateBlog(){
        return "{\"msg\":\"Blog update Successfull\"}";
    }
    @RequestMapping(value = {"/blogs"},method = {RequestMethod.GET}, produces = "application/json")
    public @ResponseBody  List<Blog> retrieveBlogs(){
        return service.getBlogs();
    }

    @RequestMapping(value = {"/blog/delete"},method = {RequestMethod.DELETE})
    public @ResponseBody  String deleteBlog(){
        return "{\"msg\":\"Blog delete Successfull\"}";
    }
}
