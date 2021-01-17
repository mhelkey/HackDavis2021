package com.example.equitablynourished.ourclasses;

public class User {

    public String email, fullname, number, address, password;

    public User(){
    }

    public User(String email, String fullname, String number, String address, String password){
        this.email = email;
        this.fullname = fullname;
        this.number = number;
        this.address = address;
        this.password = password;
    }
}

