package com.baodanwang.service;

import java.util.List;

import com.baodanwang.pojo.Users;

public interface UsersService {
	public List<Users> getUserList(String sidx, String sord) throws Exception;
	public void deleteUser(String userId) throws Exception;
	public List<Users> searchUser(String searchField, String searchString ,String sidx, String sord) throws Exception;
	public Users getUser(String userName, String userOpenid, String userAvatarurl)throws Exception;
}
