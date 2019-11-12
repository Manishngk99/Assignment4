package com.example.recyclefragment.model;

public class Contacts {
    private String name;
    private String Phone_no;
    private int imageId;

    public Contacts(String name, String phone_no, int imageId) {
        this.name = name;
        Phone_no = phone_no;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(String phone_no) {
        Phone_no = phone_no;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
