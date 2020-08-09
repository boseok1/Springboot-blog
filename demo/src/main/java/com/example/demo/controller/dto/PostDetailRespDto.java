package com.example.demo.controller.dto;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PostDetailRespDto {
    
	private int id;
    private String title;
    private String content;
    private String username;

	
	} 
