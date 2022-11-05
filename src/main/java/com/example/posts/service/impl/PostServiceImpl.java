package com.example.posts.service.impl;

import com.example.posts.domain.Post;
import com.example.posts.repo.PostRepo;
import com.example.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
   private final PostRepo postRepo;

//    @Autowired
//    ListMapper<Post,PostDto> listMapperpostToDto;
    // TODO map through stream
//    @Override
//    public List<PostDto> findAll() {
//        return postRepo.findAll();
//
////        return (List<PostDto>) listMapperpostToDto.mapList(postRepo.findAll(), new PostDto());
//    }


    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);
    }

    @Override
    public Post findById(long id) {
       return postRepo.findById(id).orElse(null);
    }

}
