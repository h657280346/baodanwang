package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.About;

public interface AboutService {

	public List<About> getAllAbout() throws Exception;
	public About getAboutById(String id) throws Exception;
	public boolean addAbout(About about) throws Exception;
	public boolean deleteAbout(String  id) throws Exception;
	public boolean updateAbout(About about) throws Exception;
	public int count() throws Exception;

}
