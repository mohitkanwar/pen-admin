package com.mk.pen.roles;



public class Role {
    public Role(long id, final String roleName){
        this.id=id;
        this.roleName = roleName;
    }
    private long id;

    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    private final String roleName;

}
