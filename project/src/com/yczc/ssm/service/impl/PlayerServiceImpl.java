package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.PlayerMapper;
import com.yczc.ssm.pojo.Player;
import com.yczc.ssm.pojo.PlayerExample;
import com.yczc.ssm.service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService{
	@Autowired
	private PlayerMapper playerMapper = null;

	@Override
	public List<Player> getAllPlayer() throws Exception {
		PlayerExample example = new PlayerExample();
		return playerMapper.selectByExample(example);
	}

	@Override
	public Player getPlayerById(String id) throws Exception {
		return playerMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean addPlayer(Player player) throws Exception {
		if(playerMapper.insertSelective(player)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePlayer(String id) throws Exception {
		if(playerMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePlayer(Player player) throws Exception {
		if(playerMapper.updateByPrimaryKeySelective(player)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		PlayerExample example = new PlayerExample();
		return playerMapper.countByExample(example);
	}

	@Override
	public List<Player> getPlayerByMatchidAndIdentity(String matchid,
			String identity) throws Exception {
		PlayerExample example = new PlayerExample();
		PlayerExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(matchid);
		criteria.andIdentityEqualTo(identity);
		return playerMapper.selectByExample(example);
	}

	@Override
	public List<Player> getPlayerByMatchid(String matchid) throws Exception {
		PlayerExample example = new PlayerExample();
		PlayerExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(matchid);
		return playerMapper.selectByExample(example);
	}
	@Override
	public List<Player> getPlayerByOpenidAndMatchid(String openid,String matchid) throws Exception {
		PlayerExample example = new PlayerExample();
		PlayerExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(matchid);
		criteria.andOpenidEqualTo(openid);
		return playerMapper.selectByExample(example);
	}
	@Override
	public boolean isPlayerByOpenidAndMatchid(String openid,String matchid) throws Exception {
		PlayerExample example = new PlayerExample();
		PlayerExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(matchid);
		criteria.andOpenidEqualTo(openid);
		List<Player> list = playerMapper.selectByExample(example);
		if(list!=null && list.size()!=0){
			return true;
		}
		return false;
	}
}
