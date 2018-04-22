package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Ballteam;

public interface BallteamService {

	public List<Ballteam> getAllBallteam() throws Exception;
	public Ballteam getBallteamById(String id) throws Exception;
	public Ballteam getBallteamByOpenIdAndTeam(String openid,String team) throws Exception;
	public boolean addBallteam(Ballteam ballteam) throws Exception;
	public boolean deleteBallteam(String  id) throws Exception;
	public boolean updateBallteam(Ballteam ballteam) throws Exception;
	public int count() throws Exception;
}
