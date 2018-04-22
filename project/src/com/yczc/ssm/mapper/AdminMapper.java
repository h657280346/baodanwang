package com.yczc.ssm.mapper;

import com.yczc.ssm.pojo.Admin;

public interface AdminMapper {

	public Admin findAdmin(String username,String password) throws Exception;
	public boolean updatePass(Admin admin) throws Exception;
}
