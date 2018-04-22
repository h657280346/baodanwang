package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Yuezhan;

public interface YuezhanService {
	public List<Yuezhan> getYuezhanByMatchidAndIdentity(String matchid,String identity) throws Exception;
	public List<Yuezhan> getYuezhanByMatchid(String matchid) throws Exception;
	public List<Yuezhan> getYuezhanByOpenidAndIdentity(String openid,String identity) throws Exception;
	public List<Yuezhan> getAllYuezhan() throws Exception;
	public Yuezhan getYuezhanById(String id) throws Exception;
	public boolean addYuezhan(Yuezhan yuezhan) throws Exception;
	public boolean deleteYuezhan(String  id) throws Exception;
	public boolean updateYuezhan(Yuezhan yuezhan) throws Exception;
	public int count() throws Exception;

}
