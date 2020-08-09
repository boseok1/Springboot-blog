package com.example.demo.model;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post {
    private int id;
    private String title;
    private String content;
    private int userId;
    private Timestamp createDate; 
}
