package com.example.posts.controller;

import com.example.posts.domain.Post;
import com.example.posts.domain.User;
import com.example.posts.service.PostService;
import com.example.posts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;


    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPost(@PathVariable long id){
        return userService.findPost(id);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id){
        return userService.findById(id);
    }

//    @GetMapping("/num")
//    public List<User> UserManyPosts(){
//        return userService.UserManyPosts();
//    }

}
