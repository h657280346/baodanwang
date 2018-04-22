package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Reward;

public interface RewardService {
	public List<Reward> getAllReward() throws Exception;
	public Reward getRewardById(String id) throws Exception;
	public boolean addReward(Reward reward) throws Exception;
	public boolean deleteReward(String  id) throws Exception;
	public boolean updateReward(Reward reward) throws Exception;
	public int count() throws Exception;

}
