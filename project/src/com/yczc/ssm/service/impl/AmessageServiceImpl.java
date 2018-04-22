package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.AmessageMapper;
import com.yczc.ssm.pojo.Amessage;
import com.yczc.ssm.pojo.AmessageExample;
import com.yczc.ssm.service.AmessageService;

@Service("amessageService")
public class AmessageServiceImpl implements AmessageService{

	@Autowired
	private AmessageMapper amessageMapper = null;
	@Override
	public List<Amessage> getAllAmessage() throws Exception {
		return amessageMapper.selectByExample(null);
	}
	@Override
	public List<Amessage> getAmessageByMopenidAndStatus(String mopenid,String status) throws Exception {
		AmessageExample example = new AmessageExample();
		AmessageExample.Criteria criteria = example.createCriteria();
		criteria.andMopenidEqualTo(mopenid);
		criteria.andStatusEqualTo(status);
		return amessageMapper.selectByExample(example);
	}
	@Override
	public Amessage getAmessageById(String id) throws Exception {
		return amessageMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean addAmessage(Amessage amessage) throws Exception {
		if(amessageMapper.insertSelective(amessage)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAmessage(String id) throws Exception {
		if(amessageMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAmessage(Amessage amessage) throws Exception {
		if(amessageMapper.updateByPrimaryKeySelective(amessage)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		return amessageMapper.countByExample(null);
	}
	@Override
	public boolean isAmessage(String popenid, String mopenid, String gameid) throws Exception {
		AmessageExample example = new AmessageExample();
		AmessageExample.Criteria criteria =example.createCriteria();
		criteria.andPopenidEqualTo(popenid);
		criteria.andMopenidEqualTo(mopenid);
		criteria.andGameidEqualTo(gameid);
		criteria.andContentLike("申请取消");
		criteria.andStatusEqualTo("0");
		List<Amessage> list = amessageMapper.selectByExample(example);
		if(list!=null && list.size()!=0){
			return true;
		}
		return false;
	}
	@Override
	public List<Amessage> getAmessageByGameid(String gameid) throws Exception {
		AmessageExample example = new AmessageExample();
		AmessageExample.Criteria criteria = example.createCriteria();
		criteria.andGameidEqualTo(gameid);
		return amessageMapper.selectByExample(example);
	}
}
