package com.cesi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@RestController
@SpringBootApplication

public class TwitterApp {
//    public static final List<String> TWEETS = Arrays.asList("titi","tata","toto");
    public static final List<String> TWEETS = new ArrayList();


    public static void main(String[] args) {
        SpringApplication.run(TwitterApp.class, args);



    }

    /*
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/tweets", method= RequestMethod.GET)
    public String helloWorld(){
        return "Liste des tweets " + TWEETS;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/hello/{id}", method= RequestMethod.GET)
    public String helloWorld(@PathVariable Integer id){
        return "Hello world " + TWEETS.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/tweets", method= RequestMethod.POST)
    public void createTweet(@RequestParam String tweet) {
        TWEETS.add(tweet);
    }*/
}