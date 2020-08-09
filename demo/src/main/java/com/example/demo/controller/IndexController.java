package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	    // 응답을 data로 받기위해서 responsebody 추가
		// (User user)를 이용하면 xxx-form-urlencoded 만 받아진다
		// (@RequestBody User user)를 이용하면 
		// jwt 등 공부하기
	
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}

	@GetMapping("auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

	@GetMapping("auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}

}

