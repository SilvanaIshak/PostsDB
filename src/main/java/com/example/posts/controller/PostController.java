package com.example.posts.controller;

import com.example.posts.domain.Post;
import com.example.posts.domain.dto.PostDto;
import com.example.posts.domain.dto.PostV2Dto;
import com.example.posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping(path ="/v1", headers = "API-VERSION=1")
    public List<PostDto> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping(value ="/v2", headers = "API-VERSION=2")
    public List<PostV2Dto> getAllPostsV2(){
        return postService.finaAllV2();
    }


    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") long id){
        return postService.findPostById(id);
    }

//    @GetMapping("/")
//    //@ResponseBody
//    public PostDto getPostById(@RequestParam Long id){
//        return postService.findPostById(id);
//   }

    @GetMapping("/author")
    public PostV2Dto getByAuthor(@RequestParam String author){
      //  return postService.finaAllV2().stream().filter(p -> p.getAuthor().equals(author)).findAny().get();
    return postService.findByAuthor(author);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") long id, @RequestBody Post p){
        postService.updateById(id, p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        postService.deleteById(id);
    }
}
