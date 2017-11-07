package com.mk.pen.blog.page;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mk.pen.domain.Blog;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageCRUDService {
    public static final String BLOG_PROPERTIES_FILE_NAME = "blog.json";
    private final String BASE_FOLDER = "/Users/mkanwar/Documents/blogs/";
    public String createBlog(Blog blog) throws IOException {

        File blogDir = new File(BASE_FOLDER +convertTitleToPath(blog.getTitle()));

        if(blogDir.exists()){
            return "Blog already created on this effective name :"+convertTitleToPath(blog.getTitle());
        }
        else {
            blogDir.mkdirs();
            File blogPropertiesFile = new File(blogDir.toString()+File.separator+ BLOG_PROPERTIES_FILE_NAME);
            FileOutputStream fOut = new FileOutputStream(blogPropertiesFile);
            OutputStreamWriter myOutWriter =new OutputStreamWriter(fOut);
            myOutWriter.append(new Gson().toJson(blog));
            myOutWriter.close();
            fOut.close();
            return "Blog Creation Successful";
        }

    }

    private String convertTitleToPath(String blogTitle) {
        /*TODO
        * Change behaviour to include replacement of all restricted characters
        * */

        return File.separator+blogTitle.replaceAll(" ","-").toLowerCase();
    }

    public List<Blog> getBlogs()  {
        File baseFolder = new File(BASE_FOLDER);
        List<Blog> blogList = new ArrayList<>();
        String[] blogs = baseFolder.list();
        for(String blogDirName:blogs){
            File blogDir = new File(baseFolder.getAbsolutePath()+File.separator+blogDirName);
            if(blogDir.isDirectory()&&(!blogDir.isHidden())){
                try {
                    File blogProperties = new File(baseFolder.getAbsolutePath()+File.separator+blogDirName+File.separator+ BLOG_PROPERTIES_FILE_NAME);
                    Gson gson = new Gson();
                    Type BLOG_TYPE = new TypeToken<Blog>() {}.getType();
                    JsonReader reader = null;
                    reader = new JsonReader(new FileReader(blogProperties));
                    Blog blog = gson.fromJson(reader, BLOG_TYPE);
                    System.out.println(blog);
                    blogList.add(blog);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return blogList;
    }
}
