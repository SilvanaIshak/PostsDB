package com.example.posts.service;

import com.example.posts.domain.Post;
import com.example.posts.domain.PostV2;
import com.example.posts.domain.dto.PostDto;
import com.example.posts.domain.dto.PostV2Dto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    List<PostV2Dto> finaAllV2();

    PostDto findPostById(long id);

    void updateById(long id, Post p);

    void deleteById(long id);

    PostV2Dto findByAuthor(String author);
}
