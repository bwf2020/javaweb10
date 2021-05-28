package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.service.IUserService;

@Controller
public class UserController {
	
	
	@Resource
	private IUserService userService;

	
	@RequestMapping("/reg")
	public String  reg(User user) {
		
		userService.reg(user);
		
		return "index.jsp";
		
		
	}
	
}
