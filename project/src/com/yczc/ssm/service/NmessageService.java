package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Nmessage;

public interface NmessageService {
	public boolean getNmessageByOpenid(String openid) throws Exception;
	public List<Nmessage> getNmessageByOpenidAndStatus(String openid,String status) throws Exception ;
	public List<Nmessage> getAllNmessage() throws Exception;
	public Nmessage getNmessageById(String id) throws Exception;
	public boolean addNmessage(Nmessage nmessage) throws Exception;
	public boolean deleteNmessage(String  id) throws Exception;
	public boolean updateNmessage(Nmessage nmessage) throws Exception;
	public int count() throws Exception;

}
