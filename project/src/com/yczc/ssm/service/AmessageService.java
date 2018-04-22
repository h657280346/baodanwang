package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Amessage;

/**
 * »¥·¢ÏûÏ¢
 * @author liu_yeye
 *
 */
public interface AmessageService {
	public List<Amessage> getAmessageByGameid(String gameid) throws Exception ;
	public boolean isAmessage(String popenid,String mopenid,String gameid) throws Exception;
	public List<Amessage> getAmessageByMopenidAndStatus(String mopenid,String status) throws Exception ;
	public List<Amessage> getAllAmessage() throws Exception;
	public Amessage getAmessageById(String id) throws Exception;
	public boolean addAmessage(Amessage amessage) throws Exception;
	public boolean deleteAmessage(String  id) throws Exception;
	public boolean updateAmessage(Amessage amessage) throws Exception;
	public int count() throws Exception;

}
