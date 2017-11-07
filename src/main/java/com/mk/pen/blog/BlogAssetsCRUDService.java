package com.mk.pen.blog;

import com.mk.pen.domain.FilesHierarchy;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.mk.pen.blog.BlogCRUDService.BASE_FOLDER;


@Service
public class BlogAssetsCRUDService {

    private static final String ASSETS_DIRECTORY = "assets";

    public List<FilesHierarchy> getBlogAssets(String blogId)  {
        File baseFolder = new File(BASE_FOLDER+blogId+File.separator+ ASSETS_DIRECTORY);
        return getBlogAssets( blogId,baseFolder);
    }

    public List<FilesHierarchy> getBlogAssets(String blogId,File baseFolder)  {
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
                        childFolder.setChildren(getBlogAssets(blogId,child));
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


    public File getBlogAsset(String blogId, String asset) {
        return new File(BASE_FOLDER+blogId+File.separator+ ASSETS_DIRECTORY+File.separator+asset);
    }
}
