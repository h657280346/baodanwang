package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.NmessageMapper;
import com.yczc.ssm.pojo.Nmessage;
import com.yczc.ssm.pojo.NmessageExample;
import com.yczc.ssm.service.NmessageService;

@Service("nmessageService")
public class NmessageServiceImpl implements NmessageService{

	@Autowired
	private NmessageMapper nmessageMapper = null;
	@Override
	public List<Nmessage> getAllNmessage() throws Exception {
		return nmessageMapper.selectByExample(null);
	}
	@Override
	public List<Nmessage> getNmessageByOpenidAndStatus(String openid,String status) throws Exception {
		NmessageExample example = new NmessageExample();
		NmessageExample.Criteria criteria = example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		criteria.andStatusEqualTo(status);
		return nmessageMapper.selectByExample(example);
	}
	
	@Override
	public Nmessage getNmessageById(String id) throws Exception {
		return nmessageMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean addNmessage(Nmessage nmessage) throws Exception {
		if(nmessageMapper.insertSelective(nmessage)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteNmessage(String id) throws Exception {
		if(nmessageMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateNmessage(Nmessage nmessage) throws Exception {
		if(nmessageMapper.updateByPrimaryKeySelective(nmessage)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		return nmessageMapper.countByExample(null);
	}
	@Override
	public boolean getNmessageByOpenid(String openid) throws Exception {
		NmessageExample example = new NmessageExample();
		NmessageExample.Criteria criteria = example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		List<Nmessage> list = nmessageMapper.selectByExample(example);
 		if(list!=null && list.size()!=0){
 			return true;
 		}
		return false;
	}
}
