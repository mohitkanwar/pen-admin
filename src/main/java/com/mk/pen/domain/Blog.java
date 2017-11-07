package com.mk.pen.domain;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;

public class Blog {
    private String title;
    private String description;
    private Date createDate;
    private Date lastModifyDate;

    public Blog(){
        createDate = new Date();
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {

       return convertTitleToPath( this.getTitle());
    }


    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
               // ", path=" + path +
                '}';
    }
    private String convertTitleToPath(String blogTitle) {
        /*TODO
        * Change behaviour to include replacement of all restricted characters
        * */

        return File.separator+blogTitle.replaceAll(" ","-").toLowerCase();
    }

}
