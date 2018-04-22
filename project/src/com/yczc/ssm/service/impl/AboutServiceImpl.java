package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.AboutMapper;
import com.yczc.ssm.pojo.About;
import com.yczc.ssm.service.AboutService;


@Service("aboutService")
public class AboutServiceImpl implements AboutService{

	@Autowired
	private AboutMapper aboutMapper = null;
	@Override
	public boolean deleteAbout(String id) throws Exception {
		if(aboutMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		return aboutMapper.countByExample(null);
	}

	@Override
	public boolean addAbout(About about) throws Exception {
		if(aboutMapper.insertSelective(about)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<About> getAllAbout() throws Exception {
		return aboutMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public About getAboutById(String id) throws Exception {
		return aboutMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateAbout(About about) throws Exception {
		if(aboutMapper.updateByPrimaryKeySelective(about)>0){
			return true;
		}
		return false;
	}

}
