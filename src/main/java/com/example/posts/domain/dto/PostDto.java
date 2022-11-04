package com.example.posts.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
}
