package com.example.posts.repo;

import com.example.posts.domain.Post;
import com.example.posts.domain.PostV2;
import com.example.posts.domain.dto.PostDto;
import com.example.posts.domain.dto.PostV2Dto;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();

    List<PostV2> findAllV2();

    Post findPostById(long id);

    void updatePostById(long id, PostDto p);

    void deleteById(long id);

    PostV2 findByAuthor(String author);
}
