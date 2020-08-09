package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Post;

public interface PostRepository {

	public void save(Post requestPost);
	
	public List<Post> findAll();
	
	public Post findOne(int id);
	
	public void deleteById(int id);
	
	public void update(Post post);
}
