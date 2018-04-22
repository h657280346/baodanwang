package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.UserMapper;
import com.yczc.ssm.pojo.User;
import com.yczc.ssm.service.UserService;

@Service("useService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper = null;
	
	public boolean addUser(User user) throws Exception {
		boolean flag = userMapper.addUser(user);
		return flag;
	}

	public List<User> findAllUser() throws Exception {
		List<User> users = userMapper.findAllUser();
		return users;
	}

	public User findUserById(String id) throws Exception {
		User user = userMapper.findUserById(id);
		return user;
	}

	public boolean deleteUser(String id) throws Exception {
		boolean flag = userMapper.deleteUser(id);
		return flag;
	}

	public User findUserByIdAndTime(String id, String time) throws Exception {
		User user = userMapper.findUserByIdAndTime(id,time);
		return user;
	}

	public int count() throws Exception {
		int count = userMapper.count();
		return count;
	}

	public int count1(String today) throws Exception {
		int count = userMapper.count1(today);
		return count;
	}

	public int count3(String old, String newday) throws Exception {
		int count = userMapper.count3(old, newday);
		return count;
	}

}
