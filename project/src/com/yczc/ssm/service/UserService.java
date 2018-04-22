package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.User;

public interface UserService {

	public boolean addUser(User user) throws Exception;
	public List<User> findAllUser() throws Exception;
	public User findUserById(String id) throws Exception;
	public boolean deleteUser(String id) throws Exception;
	public User findUserByIdAndTime(String id,String time) throws Exception;
	public int count() throws Exception;
	public int count1(String today) throws Exception;
	public int count3(String old,String newday) throws Exception;
}
