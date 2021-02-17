package com.simplechat.server;

import java.util.ArrayList;

public class RegisteredUsers {
    private ArrayList<User> users;

    public RegisteredUsers(){
        users = new ArrayList<>();
    }

    public void addUser(User usr){
        users.add(usr);
    }

    public void removeUser(User usr){
        users.remove(usr);
    }

    public void authUser(User usr){

    }

}
