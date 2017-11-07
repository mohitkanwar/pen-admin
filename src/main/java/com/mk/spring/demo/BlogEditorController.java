package com.mk.spring.demo;

import com.mk.pen.blog.BlogAssetsCRUDService;
import com.mk.pen.blog.BlogCRUDService;
import com.mk.pen.blog.BlogContentCRUDService;
import com.mk.pen.blog.BlogTemplatesCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogEditorController {
    @Autowired
    private BlogCRUDService service;
    @Autowired
    private BlogTemplatesCRUDService templatesCRUDService;
    @Autowired
    private BlogAssetsCRUDService assetsCRUDService;
    @Autowired
    private BlogContentCRUDService contentCRUDService;
    @RequestMapping(value = {"/blog-editor/{blogId}/contents","/blog-editor/{blogId}"} )
    public String blogContentEditor(@PathVariable String blogId,@RequestParam(value = "content", required = false) String content,Model model) {
        System.out.println("Received :"+blogId);
        model.addAttribute("blogId",blogId);
        model.addAttribute("blogContents",contentCRUDService.getBlogTemplates(blogId));
        if(content!=null){
            model.addAttribute("content",contentCRUDService.getBlogTemplate(blogId,content));
        }

        return "blog-content-editor";
    }
    @RequestMapping(value = {"/blog-editor/{blogId}/assets"} )
    public String blogAssetsEditor(@PathVariable String blogId,@RequestParam(value = "asset", required = false) String asset,Model model) {
        System.out.println("Received :"+blogId);
        model.addAttribute("blogId",blogId);
        //
        model.addAttribute("blogAssets",assetsCRUDService.getBlogAssets(blogId));
        model.addAttribute("asset",assetsCRUDService.getBlogAsset(blogId,asset));
        return "blog-assets-editor";
    }

    @RequestMapping(value = {"/blog-editor/{blogId}/templates"} )
    public String blogTemplateEditor(@PathVariable String blogId,@RequestParam(value = "template", required = false) String template,Model model) {
        System.out.println("Received :"+blogId);
        model.addAttribute("blogId",blogId);
        model.addAttribute("blogTemplates",templatesCRUDService.getBlogTemplates(blogId));
        if(template!=null){
            model.addAttribute("templateContent",templatesCRUDService.getBlogTemplate(blogId,template));
        }

        return "blog-templates-editor";
    }
}
