package com.example.posts.service;

import com.example.posts.domain.Post;
import com.example.posts.domain.PostV2;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    void deleteById(long id);

    void save(Post p);

    Post findById(long id);
}
