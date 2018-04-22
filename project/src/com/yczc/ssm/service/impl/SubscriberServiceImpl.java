package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.SubscriberMapper;
import com.yczc.ssm.pojo.Subscriber;
import com.yczc.ssm.pojo.SubscriberExample;
import com.yczc.ssm.service.SubscriberService;

@Service("subscriberService")
public class SubscriberServiceImpl implements SubscriberService{

	@Autowired
	private SubscriberMapper subscriberMapper = null;
	@Override
	public List<Subscriber> getAllSubscriber() throws Exception {
		return subscriberMapper.selectByExample(null);
	}

	@Override
	public Subscriber getSubscriberById(String id) throws Exception {
		return subscriberMapper.selectByPrimaryKey(id);
	}
	@Override
	public Subscriber getSubscriberByOpenId(String openid) throws Exception{
		SubscriberExample example = new SubscriberExample();
		SubscriberExample.Criteria c = example.createCriteria();
		c.andOpenidEqualTo(openid);
		List<Subscriber> list = subscriberMapper.selectByExample(example);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@Override
	public boolean addSubscriber(Subscriber subscriber) throws Exception {
		if(subscriberMapper.insertSelective(subscriber)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSubscriber(String id) throws Exception {
		if(subscriberMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSubscriber(Subscriber subscriber) throws Exception {
		if(subscriberMapper.updateByPrimaryKeySelective(subscriber)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		return subscriberMapper.countByExample(null);
	}

}
