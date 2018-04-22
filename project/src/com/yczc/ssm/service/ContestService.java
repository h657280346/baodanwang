package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Contest;

public interface ContestService {
	public boolean updateContestByStatus(Contest contest) throws Exception ;
	public List<Contest> getContestByTeamid(String teamid) throws Exception;
	public List<Contest> getAllContest() throws Exception;
	public List<Contest> getContestByStatus(String status) throws Exception;
	public Contest getContestById(String id) throws Exception;
	public boolean addContest(Contest contest) throws Exception;
	public boolean deleteContest(String  id) throws Exception;
	public boolean updateContest(Contest contest) throws Exception;
	public int count() throws Exception;
	public int count1(String time) throws Exception;
	public int count3(String format, String time) throws Exception;

}
