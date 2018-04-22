package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.RewardMapper;
import com.yczc.ssm.pojo.Reward;
import com.yczc.ssm.service.RewardService;

@Service("rewardService")
public class RewardServiceImpl implements RewardService{

	@Autowired
	private RewardMapper rewardMapper = null;
	@Override
	public boolean deleteReward(String id) throws Exception {
		if(rewardMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		return rewardMapper.countByExample(null);
	}

	@Override
	public boolean addReward(Reward reward) throws Exception {
		if(rewardMapper.insertSelective(reward)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Reward> getAllReward() throws Exception {
		return rewardMapper.selectByExample(null);
	}

	@Override
	public Reward getRewardById(String id) throws Exception {
		return rewardMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateReward(Reward reward) throws Exception {
		if(rewardMapper.updateByPrimaryKeySelective(reward)>0){
			return true;
		}
		return false;
	}

}
