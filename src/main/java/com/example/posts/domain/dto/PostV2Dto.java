package com.example.posts.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostV2Dto {
    long id;
    String title;
    String content;
    String author;
    String likes;
}
