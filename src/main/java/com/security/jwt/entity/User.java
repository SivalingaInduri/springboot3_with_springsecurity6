package com.security.jwt.entity;

import jakarta.persistence.*;

@Entity
@Table(name="User_Table")
public class User {

    @Id
    private Integer id;
    private String userName;
    private String password;
   // private String yesu:

    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
