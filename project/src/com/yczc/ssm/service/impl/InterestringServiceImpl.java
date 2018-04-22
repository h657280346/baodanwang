package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.InterestingMapper;
import com.yczc.ssm.pojo.Interesting;
import com.yczc.ssm.service.InterestingService;

@Service("interestingService")
public class InterestringServiceImpl implements InterestingService{

	@Autowired
	private InterestingMapper interestingMapper = null;
	
	public boolean addInteresting(Interesting interesting) throws Exception {
		boolean flag = interestingMapper.addInteresting(interesting);
		return flag;
	}

	public List<Interesting> findAllInteresting() throws Exception {
		List<Interesting> ins = interestingMapper.findAllInteresting(); 
		return ins;
	}

	public Interesting findInterestingById(String id) throws Exception {
		Interesting in = interestingMapper.findInterestingById(id);
		return in;
	}

	public boolean updateInteresting(Interesting interestring) throws Exception {
		boolean flag = interestingMapper.updateInteresting(interestring);
		return flag;
	}

	public boolean deleteInteresting(String id) throws Exception {
		boolean flag = interestingMapper.deleteInteresting(id);
		return flag;
	}

	public int count() throws Exception {
		int count = interestingMapper.count();
		return count;
	}

	public List<Interesting> findInterestingByFigure() throws Exception {
		List<Interesting> interesting = interestingMapper.findInterestingByFigure();
		return interesting;
	}

	public boolean updateInterestingView(String id) throws Exception {
		boolean flag = interestingMapper.updateInterestingView(id);
		return flag;
	}

}
