package com.syz.demo.mvp.model.bean;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class User {
    private String id;
    private String name;
    private String age;
    private boolean isAudlt;


    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
        setAudlt(age.equals("18"));
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAudlt() {
        return isAudlt;
    }

    public void setAudlt(boolean audlt) {
        isAudlt = audlt;
    }
}
