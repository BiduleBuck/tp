package com.cesi;

import java.util.List;
import com.cesi.Models.Tweet;
import com.cesi.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    public List<Tweet> findById(String id);
    public List<Tweet> findByUser(String id);
    public List<Tweet> findByContent(String content);
    public List<Tweet> findByDate(String date);
}