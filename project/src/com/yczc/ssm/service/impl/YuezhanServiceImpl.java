package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.YuezhanMapper;
import com.yczc.ssm.pojo.ContestExample;
import com.yczc.ssm.pojo.Yuezhan;
import com.yczc.ssm.pojo.YuezhanExample;
import com.yczc.ssm.service.YuezhanService;

@Service("yuezhanService")
public class YuezhanServiceImpl implements YuezhanService{
	@Autowired
	private YuezhanMapper yuezhanMapper = null;

	@Override
	public List<Yuezhan> getYuezhanByOpenidAndIdentity(String openid,String identity) throws Exception{
		YuezhanExample example = new YuezhanExample();
		YuezhanExample.Criteria criteria = example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		criteria.andIdentityEqualTo(identity);
		List<Yuezhan> list = yuezhanMapper.selectByExample(example);
		if(list.size()==0){
			return null;
		}
		return list;
	}
	
	@Override
	public List<Yuezhan> getAllYuezhan() throws Exception {
		return yuezhanMapper.selectByExample(null);
	}

	@Override
	public Yuezhan getYuezhanById(String id) throws Exception {
		
		return yuezhanMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean addYuezhan(Yuezhan yuezhan) throws Exception {
		if(yuezhanMapper.insertSelective(yuezhan)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteYuezhan(String id) throws Exception {
		if(yuezhanMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateYuezhan(Yuezhan yuezhan) throws Exception {
		if(yuezhanMapper.updateByPrimaryKeySelective(yuezhan)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		YuezhanExample example = new YuezhanExample();
		YuezhanExample.Criteria criteria = example.createCriteria();
		criteria.andIdentityEqualTo("m");
		return yuezhanMapper.countByExample(example);
	}

	@Override
	public List<Yuezhan> getYuezhanByMatchid(String matchid) throws Exception {
		YuezhanExample example = new YuezhanExample();
		YuezhanExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(matchid);
		return yuezhanMapper.selectByExample(example);
	}

	@Override
	public List<Yuezhan> getYuezhanByMatchidAndIdentity(String matchid,
			String identity) throws Exception {
		YuezhanExample example = new YuezhanExample();
		YuezhanExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(matchid);
		criteria.andIdentityEqualTo(identity);
		return yuezhanMapper.selectByExample(example);
	}

}
