package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Interesting;

public interface InterestingService {


	
	public boolean addInteresting(Interesting interesting) throws Exception;
	public List<Interesting> findAllInteresting() throws Exception;
	public Interesting findInterestingById(String id) throws Exception;
	public boolean updateInteresting(Interesting interestring) throws Exception;
	public boolean deleteInteresting(String id) throws Exception;
	public int count() throws Exception;
	public List<Interesting> findInterestingByFigure() throws Exception;
	public boolean updateInterestingView(String id) throws Exception;
}
