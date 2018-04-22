package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.PlanMapper;
import com.yczc.ssm.pojo.Plan;
import com.yczc.ssm.service.PlanService;

@Service("planService")
public class PlanServiceImpl implements PlanService{
	

	@Autowired
	private PlanMapper planMapper = null;

	public boolean addPlan(Plan plan) throws Exception {
		boolean flag = planMapper.addPlan(plan);
		return flag;
	}

	public List<Plan> findAllPlan() throws Exception {
		List<Plan> plans = planMapper.findAllPlan();
		return plans;
	}

	public Plan findPlanById(String id) throws Exception {
		Plan plan = planMapper.findPlanById(id);
		return plan;
	}

	public boolean updatePlan(Plan plan) throws Exception {
		boolean flag = planMapper.updatePlan(plan);
		return flag;
	}

	public boolean deletePlan(String id) throws Exception {
		boolean flag = planMapper.deletePlan(id);
		return flag;
	}

	public int count() throws Exception {
		int count = planMapper.count();
		return count;
	}


}
