package com.cesi.controller;

import com.cesi.Models.Tweet;
import com.cesi.Models.User;
import com.cesi.TweetRepository;
import com.cesi.TwitterApp;
import com.cesi.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by fab on 22/08/16.
 */


@RestController
public class TweetController {

    @Autowired
    private TweetRepository tweetsRepository;

    @Autowired
    private UserRepository userRepository;

    //public static final List<String> TWEETS = Arrays.asList("titi","tata","toto");
    //public static final List<Tweet> TWEETS = new ArrayList<Tweet>();
    //public static final Map<Integer, Tweet> TWEETS = new HashMap<Integer, Tweet>();

    @Profile("dev")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/createmongodata", method= RequestMethod.GET)//url REST
    public void createMongoData(){

        tweetsRepository.deleteAll();
        userRepository.deleteAll();

        //Users
        User user0 = new User("0", "Giai Joe", "Joe", "Desert Eagle");
        User user1 = new User("1", "John Doe", "JD", "Nobody");
        User user2 = new User("2", "Michael Jackson", "Mike", "captain eo");

        //Save a couple of users
        userRepository.save(user0);
        userRepository.save(user1);
        userRepository.save(user2);

        // save a couple of customers
        tweetsRepository.save(new Tweet("1", user0, "C'est clair...", null));
        tweetsRepository.save(new Tweet("2", user1, "Pas d'accord.", null));
        tweetsRepository.save(new Tweet("3", user2, "J'aime aussi les granolas mais moins.", null));

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/get/tweets", method= RequestMethod.GET)
    public List<Tweet> getTweets(){

        return tweetsRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/get/{id}", method= RequestMethod.GET)
    public String getTweet(@PathVariable String id){

        return tweetsRepository.findById(id).get(0).getUser().getName() + " a tweeté...";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/getalltweetsfrom/{id}", method= RequestMethod.GET)
    public List<Tweet> getAllTweetsFrom(@PathVariable String id){

        return tweetsRepository.findByUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/tweets", method= RequestMethod.POST)
    public void createTweet(@Valid @RequestBody Tweet tweet) {
        tweetsRepository.save(tweet);
    }
}