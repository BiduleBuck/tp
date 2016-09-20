package com.cesi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by fab on 22/08/16.
 */
public class Tweet {
    @NotNull
    @Id
    private String id;

    @NotNull
    @DBRef
    private User user;

    private String content;

    private Date date;
     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet(String id, User user, String content, Date date){
        this.id = id;
        this.user = user;
        this.content = content;
        this.date = date;
    }

}
