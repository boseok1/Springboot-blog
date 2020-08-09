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

public class Comment {
      private int id;
      private int userId;
      private int postId;
      private String content;
      private Timestamp createDate;
}