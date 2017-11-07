package com.mk.pen.domain;

import java.util.List;

public class FilesHierarchy {
    private String name;
    private String path;
    private boolean directory;
    private List<FilesHierarchy> children;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public boolean isParent() {
        return (children!=null)&&(children.size()>0);
    }


    public List<FilesHierarchy> getChildren() {
        return children;
    }

    public void setChildren(List<FilesHierarchy> children) {
        this.children = children;
    }


}
