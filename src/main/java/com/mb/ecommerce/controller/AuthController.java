package com.mb.ecommerce.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ecommerce.entity.JwtRequest;
import com.mb.ecommerce.entity.JwtResponse;
import com.mb.ecommerce.entity.User;
import com.mb.ecommerce.service.JwtService;
import com.mb.ecommerce.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private JwtService jwtService;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userServiceImpl.initRolesAndUser();
	}
	
	
	@PostMapping({"/signup"})
	public User registerNewUser(@RequestBody User user) {
		return userServiceImpl.registerNewUser(user);
	}
	
	@PostMapping({"/signup/admin"})
	public User registerNewAdmin(@RequestBody User user) {
		return userServiceImpl.registerNewAdmin(user);
	}
	
	@PostMapping({"/signin"})
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		return jwtService.createJwtToken(jwtRequest);
		
	}
	
//	@GetMapping({"/admin/hello"})
//	@PreAuthorize("hasRole('Admin')")
//	public String adminHello() {
//		return "welcome to Admin Hello";
//	}
//	
//	@GetMapping({"/user/hello"})
//	@PreAuthorize("hasAnyRole('User','Admin')")
//	public String userHello() {
//		return "welcome to Admin and User Hello";
//	}
}
