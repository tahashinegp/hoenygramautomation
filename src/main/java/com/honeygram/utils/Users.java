package com.honeygram.utils;

public class Users {
    private String userName;
    private String pass;

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
