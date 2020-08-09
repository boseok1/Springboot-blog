package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

//Controller, Repository, Configuration, Service, Component
//RestController, Bean

@Service // IOC
public class UserService {

	@Autowired
	private UserRepository userRepository; // DI

	@Transactional
	public void 회원가입(User user) {
		user.setRole("Role_USER");
		userRepository.save(user);
	}

	// "셀렉트만 하는 트랜잭션이다" 라는 것을 명시 readOnly
	@Transactional(readOnly = true)
	public User 로그인(User user) {
		return userRepository.login(user);
	}
}
