package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.handler.exception.MyRoleException;
import com.example.demo.controller.dto.CommonRespDto;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	private final PostRepository postRepository; // 인증용이라 서비스대신 리파지토리 가져오기

	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}

	@GetMapping("/post")
	public CommonRespDto<?> postProc(@RequestBody Post requestPost) { // @RequestBody를 사용하여 제이슨을 자바객체로
		System.out.println(requestPost.getTitle());
		System.out.println(requestPost.getContent());
		System.out.println(requestPost.getUserId());
		postService.글쓰기(requestPost);
		return new CommonRespDto<String>(1, "글쓰기 성공");
	}
	
//	@GetMapping("/post")
//	public @ResponseBody String postProc(User user) { // @RequestBody를 사용하여 제이슨을 자바객체로
//		return "test1";
//	}


	@GetMapping("/posts")
	public String getPosts(Model model) {
		List<Post> posts = postService.목록보기();
		model.addAttribute("posts", posts);
		return "index";
	}

//?주소 -> 쿼리스트링 
	// /post/{id} -> 파라메터를 받는 것
	@GetMapping("/post/{id}") // 요새는 다 주소 매핑이 가능하다 - id를 매개변수로
	public String getPost(@PathVariable int id, Model model) {
		model.addAttribute("postDetailRespDto", postService.상세보기(id));
		return "post/detail";

	}

	@DeleteMapping("/post/{id}") // 매개변수로 DI (HttpSession)
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id, HttpSession session) throws MyRoleException {

		// 세션값 확인, 글의 주인 확인
		User principal = (User) session.getAttribute("principal");
		Post postEntity = postRepository.findOne(id); // 글의 주인
		if (principal.getId() != postEntity.getUserId()) {
			return new CommonRespDto<String>(-1, "삭제 실패");
//				throw new MyRoleException();
		}

		postService.게시글하나삭제하기(id);
		return new CommonRespDto<String>(1, "삭제 성공");
	}

	@PutMapping("/post/{id}") // JSON이니까 requestbody로 받아야한다
	public @ResponseBody CommonRespDto<?> deleteById(@RequestBody Post post) {
		postService.게시글수정하기(post);
		return new CommonRespDto<String>(1, "수정 성공");
	}

}
