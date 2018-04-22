package com.yczc.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.AdminMapper;
import com.yczc.ssm.pojo.Admin;
import com.yczc.ssm.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper = null;
	public Admin findAdmin(String username, String password) throws Exception {
		Admin admin =  adminMapper.findAdmin(username, password);
		return admin;
	}
	public boolean updatePass(Admin admin) throws Exception {
		boolean flag = adminMapper.updatePass(admin);
		return flag;
	}

}
