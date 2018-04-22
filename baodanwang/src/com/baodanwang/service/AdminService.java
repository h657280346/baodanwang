package com.baodanwang.service;

import java.util.List;

import com.baodanwang.pojo.Admin;

public interface AdminService {
	public List<Admin> findAdmin(String username,String password) throws Exception;
	public boolean updataPwd(String username,String password)throws Exception;
}
