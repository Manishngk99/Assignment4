package com.example.recyclefragment;

import java.util.List;

public class LoginCheck {
    static List<User> UserList;
    boolean result = false;
    String username, password;

    public static void setUserlist(List<User> userlist) {
        UserList = userlist;
    }

    public static List<User> getUserlist() {
        return UserList;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getUserList() {
        return UserList;
    }

    public boolean checkLogin() {
        if (getUserList() != null) {

            for (int i = 0; i < getUserList().size(); i++) {
                final User userdetail = getUserList().get(i);
                if (username.equals(userdetail.getUser()) && password.equals(userdetail.getPass())) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;

    }


}
