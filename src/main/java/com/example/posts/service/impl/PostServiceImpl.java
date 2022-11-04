package com.example.posts.service.impl;

import com.example.posts.domain.Post;
import com.example.posts.domain.PostV2;
import com.example.posts.domain.dto.PostDto;
import com.example.posts.domain.dto.PostV2Dto;
import com.example.posts.helper.ListMapper;
import com.example.posts.repo.PostRepo;
import com.example.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
   private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post,PostDto> listMapperpostToDto;

    @Autowired
    ListMapper<PostV2,PostV2Dto> listMapperpostToDtoV2;
    @Override
    public List<PostDto> findAll() {
        //return postRepo.findAll();
        return (List<PostDto>) listMapperpostToDto.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public List<PostV2Dto> finaAllV2() {
        return (List<PostV2Dto>) listMapperpostToDtoV2.mapList(postRepo.findAllV2(),new PostV2Dto());
    }


    @Override
    public PostDto findPostById(long id) {
       // return postRepo.findPostById(id);
    return modelMapper.map(postRepo.findPostById(id), PostDto.class);
    }

    @Override
    public void updateById(long id, Post p) {
       postRepo.updatePostById(id, modelMapper.map(p, PostDto.class));
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public PostV2Dto findByAuthor(String author) {
        return modelMapper.map(postRepo.findByAuthor(author), PostV2Dto.class);
    }
}
