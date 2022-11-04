package com.example.posts.repo.impl;

import com.example.posts.domain.Post;
import com.example.posts.domain.PostV2;
import com.example.posts.domain.dto.PostDto;
import com.example.posts.domain.dto.PostV2Dto;
import com.example.posts.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts = new ArrayList<>();
    private static long PostId = 100L;
    static {
        Post p1 = new Post(101L, "title1", "content1", "author1");
        Post p2 = new Post(102L, "title2", "content2", "author2");
        posts.add(p1);
        posts.add(p2);
    }


    private static List<PostV2> postsV2 = new ArrayList<>();
    private static long PostIdV2 = 100L;
    static {
        PostV2 postV21 = new PostV2(101L, "title1", "content1", "author1", "amazing");
        PostV2 postV22 = new PostV2(102L, "title2", "content2", "author2", "good");
        postsV2.add(postV21);
        postsV2.add(postV22);
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public List<PostV2> findAllV2(){
        return postsV2;
    }

    @Override
    public Post findPostById(long id) {
        return posts.stream()
                .filter(p ->p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updatePostById(long id, PostDto p) {
        Post toUpdate = findPostById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
    }

    @Override
    public void deleteById(long id) {
        var post = posts.stream()
                .filter(p -> p.getId()==id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public PostV2 findByAuthor(String author) {
        return postsV2.stream()
                .filter(p ->p.getAuthor().equals(author))
                .findAny()
                .orElse(null);
    }
}
