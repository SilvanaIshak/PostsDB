package com.example.posts.repo;

import com.example.posts.domain.Post;
import com.example.posts.domain.PostV2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll();

}
