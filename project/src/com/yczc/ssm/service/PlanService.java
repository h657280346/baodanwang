package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Plan;

public interface PlanService {

	public boolean addPlan(Plan plan) throws Exception;
	public List<Plan> findAllPlan() throws Exception;
	public Plan findPlanById(String id) throws Exception;
	public boolean updatePlan(Plan plan) throws Exception;
	public boolean deletePlan(String id) throws Exception;
	public int count() throws Exception;
}
