package com.example.posts.repo;

import com.example.posts.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAll();

//    @Query(value = "select u from User u where u.posts.size > ?1")
//    public List<User> UserManyPosts();

}
