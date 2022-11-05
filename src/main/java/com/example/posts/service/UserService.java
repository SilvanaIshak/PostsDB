package com.example.posts.service;

import com.example.posts.domain.Post;
import com.example.posts.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    List<Post> findPost(long id);

    User findById(long id);

   public List<User> UserPosts();

    List<User> UserPostsCount(int count);
}
