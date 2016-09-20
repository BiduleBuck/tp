package com.cesi;

import com.cesi.Models.Tweet;
import com.cesi.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findById(String id);
    public List<User> findByName(String name);
    public List<User> findByLogin(String login);
    public List<User> findByPassword(String Password);
}
