package com.mk.pen.blog;

import com.mk.pen.domain.FilesHierarchy;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.mk.pen.blog.BlogCRUDService.BASE_FOLDER;
@Service
public class BlogTemplatesCRUDService {
    private static final String TEMPLATES_DIRECTORY = "templates";
    public List<FilesHierarchy> getBlogTemplates(String blogId)  {
        File baseFolder = new File(BASE_FOLDER+blogId+File.separator+ TEMPLATES_DIRECTORY);
        return getBlogTemplates( blogId,baseFolder);
    }

    public List<FilesHierarchy> getBlogTemplates(String blogId,File baseFolder)  {
        List<FilesHierarchy> fh = new ArrayList<>();
        if(baseFolder.isDirectory()){
            String[] templates = baseFolder.list();
            if(templates!=null){
                for(String template:templates) {
                    System.out.println(template);
                    File child = new File(baseFolder.getAbsolutePath()+File.separator+template);
                    if(child.isHidden()){
                        continue;
                    }
                    if(child.isDirectory()){
                        FilesHierarchy childFolder = new FilesHierarchy();
                        childFolder.setChildren(getBlogTemplates(blogId,child));
                        childFolder.setPath(child.getPath());
                        childFolder.setName(child.getName());
                        childFolder.setDirectory(true);
                        fh.add(childFolder);
                    }else{
                        FilesHierarchy childFile = new FilesHierarchy();
                        childFile.setDirectory(false);
                        childFile.setName(child.getName());
                        childFile.setPath(child.getPath());
                        fh.add(childFile);
                    }
                }
            }
        }

        return fh;
    }


    public String getBlogTemplate(String blogId, String template) {
        File templateFile = new File(BASE_FOLDER+blogId+File.separator+ TEMPLATES_DIRECTORY+File.separator+template);
        System.out.println(template);
        try {
            return  new String(Files.readAllBytes(Paths.get(templateFile.toURI())));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
