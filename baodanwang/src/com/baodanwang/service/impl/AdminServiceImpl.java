package com.baodanwang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baodanwang.mapper.AdminMapper;
import com.baodanwang.pojo.Admin;
import com.baodanwang.pojo.AdminExample;
import com.baodanwang.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper = null;

	public List<Admin> findAdmin(String username, String password) throws Exception {
		AdminExample example = new AdminExample();
		AdminExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<Admin> admins = adminMapper.selectByExample(example);
		return admins;
	}

	@Override
	public boolean updataPwd(String username, String password) throws Exception {
		AdminExample example = new AdminExample();
		AdminExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		int result = adminMapper.updateByExample(admin, example);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

}
