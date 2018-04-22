package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Subscriber;

public interface SubscriberService {
	public List<Subscriber> getAllSubscriber() throws Exception;
	public Subscriber getSubscriberById(String id) throws Exception;
	public Subscriber getSubscriberByOpenId(String openid) throws Exception;
	public boolean addSubscriber(Subscriber subscriber) throws Exception;
	public boolean deleteSubscriber(String  id) throws Exception;
	public boolean updateSubscriber(Subscriber subscriber) throws Exception;
	public int count() throws Exception;
}
