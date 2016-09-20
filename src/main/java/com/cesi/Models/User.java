package com.cesi.Models;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by fab on 23/08/16.
 */
public class User {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @Id

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String login;

    @NotNull
    private String password;

    //alt insert
    public User(String id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }
}