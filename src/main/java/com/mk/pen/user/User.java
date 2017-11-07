package com.mk.pen.user;



public class User {
    public User(long id,String firstName, String lastName){
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;
}
