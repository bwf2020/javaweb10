package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.mapper.UserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public void reg(User user) {


		System.out.println("调用用户业务");
		
		userMapper.save(user);
		
		//System.out.println(1/0);
		
		System.out.println("保存成功");
		

	}

}
