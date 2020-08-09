package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Post;

public interface PostRepository {

	public void save(Post requestPost);
	
	public List<Post> findAll();
}
