package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.dto.CommonRespDto;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService ;
	private final PostRepository postRepository; // 인증용이라 서비스대신 리파지토리 가져오기
	
	@GetMapping("/post/saveForm")
     public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post requestPost) { //@RequestBody를 사용하여 제이슨을 자바객체로
	System.out.println(requestPost.getTitle());
	System.out.println(requestPost.getContent());
	System.out.println(requestPost.getUserId());
	postService.글쓰기(requestPost);
	return new CommonRespDto<String>(1, "글쓰기 성공");
}
  @GetMapping("/posts")
  public String getPosts(Model model) {
	  List<Post> posts = postService.목록보기();
	  model.addAttribute("posts",posts);
	  return "index";
  }
}
