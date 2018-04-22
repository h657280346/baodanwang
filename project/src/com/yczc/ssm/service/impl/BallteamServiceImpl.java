package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.BallteamMapper;
import com.yczc.ssm.pojo.Ballteam;
import com.yczc.ssm.pojo.BallteamExample;
import com.yczc.ssm.service.BallteamService;

@Service("ballteamService")
public class BallteamServiceImpl implements BallteamService{
	@Autowired
	private BallteamMapper ballteamMappper = null;

	@Override
	public List<Ballteam> getAllBallteam() throws Exception {
		return ballteamMappper.selectByExample(null);
	}

	@Override
	public Ballteam getBallteamById(String id) throws Exception {
		return ballteamMappper.selectByPrimaryKey(id);
	}

	@Override
	public Ballteam getBallteamByOpenIdAndTeam(String openid, String team)
			throws Exception {
		BallteamExample example = new BallteamExample();
		BallteamExample.Criteria criteria = example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		criteria.andTeamEqualTo(team);
		List<Ballteam>  list = ballteamMappper.selectByExample(example);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@Override
	public boolean addBallteam(Ballteam ballteam) throws Exception {
		if(ballteamMappper.insertSelective(ballteam)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBallteam(String id) throws Exception {
		if(ballteamMappper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBallteam(Ballteam ballteam) throws Exception {
		if(ballteamMappper.updateByPrimaryKeySelective(ballteam)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		return ballteamMappper.countByExample(null);
	}

}
