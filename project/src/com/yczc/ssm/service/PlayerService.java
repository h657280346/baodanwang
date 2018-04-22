package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Player;

public interface PlayerService {
	public List<Player> getPlayerByOpenidAndMatchid(String openid,String matchid) throws Exception;
	public boolean isPlayerByOpenidAndMatchid(String openid,String matchid) throws Exception ;
	public List<Player> getPlayerByMatchid(String matchid) throws Exception;
	public List<Player> getPlayerByMatchidAndIdentity(String matchid,String identity) throws Exception; 
	public List<Player> getAllPlayer() throws Exception;
	public Player getPlayerById(String id) throws Exception;
	public boolean addPlayer(Player player) throws Exception;
	public boolean deletePlayer(String  id) throws Exception;
	public boolean updatePlayer(Player player) throws Exception;
	public int count() throws Exception;
}
