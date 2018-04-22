package com.yczc.ssm.service;

import com.yczc.ssm.pojo.Admin;

public interface AdminService {
	public Admin findAdmin(String username,String password) throws Exception;
	public boolean updatePass(Admin admin) throws Exception;
}
