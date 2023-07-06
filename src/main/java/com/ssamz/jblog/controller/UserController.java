package com.ssamz.jblog.controller;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssamz.jblog.entity.UserEntity;
import com.ssamz.jblog.exception.JBlogException;
import com.ssamz.jblog.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/user/get/{id}")
	public @ResponseBody UserEntity getUser(@PathVariable Long id) {
		// 특정 id 에 해당하는 User 객체 리턴
		UserEntity findUser = userService.findById(id).orElseThrow(new Supplier<JBlogException>() {
			@Override
			public JBlogException get() {
				return new JBlogException(id + "를 가진 회원이 존재하지 않습니다");
			}
		});
		return findUser;
	}
	
	@PutMapping("/user")
	public @ResponseBody String insertUser(@RequestBody UserEntity user) {
		// 특정 id 에 해당하는 User 객체 리턴
		userService.save(user);
		return user.getUsername() + " 회원 수정 성공";
	}
	
	@PutMapping("/user")
	public @ResponseBody String updateUser(@RequestBody UserEntity user) {
		// 특정 id 에 해당하는 User 객체 리턴
		UserEntity findUser = userService.findById(user.getId()).orElseThrow(new Supplier<JBlogException>() {
			@Override
			public JBlogException get() {
				return new JBlogException(user.getId() + "를 가진 회원이 존재하지 않습니다");
			}
		});
		userService.updateUser(findUser, user);
		return "회원 수정 성공";
	}
	
	@DeleteMapping("/user/get/{id}")
	public @ResponseBody String deleteUser(@PathVariable Long id) {
		userService.deleteById(id);
		return "회원 삭제 성공";
	}

	@GetMapping("/auth/insertUser") 
	public String insertUser() {
		return "user/insertUser";
	}
	
	

}
