package com.yczc.ssm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.ContestMapper;
import com.yczc.ssm.pojo.Contest;
import com.yczc.ssm.pojo.ContestExample;
import com.yczc.ssm.service.ContestService;

@Service("contestService")
public class ContestServiceImpl implements ContestService{
	
	@Autowired
	private ContestMapper contestMapper=null;

	@Override
	public List<Contest> getAllContest() throws Exception {
		return contestMapper.selectByExample(null);
	}

	@Override
	public Contest getContestById(String id) throws Exception {

		return contestMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean addContest(Contest contest) throws Exception {
		if( contestMapper.insertSelective(contest)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContest(String id) throws Exception {
		if( contestMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateContest(Contest contest) throws Exception {
		if( contestMapper.updateByPrimaryKeySelective(contest)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateContestByStatus(Contest contest) throws Exception {
		if( contestMapper.updateByPrimaryKey(contest)>0){
			return true;
		}
		return false;
	}
	@Override
	public int count() throws Exception {
		return contestMapper.countByExample(null);
	}
	@Override
	public int count1(String today) throws Exception {
		String todaybegin=today+" "+"00:00";
		String todayend=today+" "+"24:00";
		int count = contestMapper.count1(todaybegin,todayend);
		return count;
	}
	@Override
	public int count3(String old, String newday) throws Exception {
		 old=old+" "+"00:00";
		 newday=newday+" "+"24:00";
		int count = contestMapper.count3(old, newday);
		return count;
	}
	
	@Override
	public List<Contest> getContestByStatus(String status) throws Exception {
		List<Contest> list = this.getAllContest();
		Iterator<Contest> lt=  list.iterator();
		while (lt.hasNext()) {
			Contest c = lt.next();
			if(!c.getStatus().equals(status)){
				lt.remove();
			}
		}
		return list;
	}

	@Override
	public List<Contest> getContestByTeamid(String teamid) throws Exception {
		ContestExample pexample = new ContestExample();
		ContestExample.Criteria pcriteria = pexample.createCriteria();
		pcriteria.andPteamidEqualTo(teamid);
		ContestExample mexample = new ContestExample();
		ContestExample.Criteria mcriteria = mexample.createCriteria();
		mcriteria.andMteamidEqualTo(teamid);
		List<Contest> plist = contestMapper.selectByExample(pexample);
		List<Contest> mlist = contestMapper.selectByExample(mexample);
		Set<Contest> set = new LinkedHashSet<Contest>();  
		set.addAll(plist);  
		set.addAll(mlist);  
		List<Contest> list = new ArrayList<Contest>(set); 
		return list;
	}

}
