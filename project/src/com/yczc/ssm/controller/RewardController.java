package com.yczc.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.taskdefs.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yczc.ssm.pojo.Reward;
import com.yczc.ssm.service.RewardService;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;


/**
 * 成功奖励
 * @author liu_yeye
 *
 */
@Controller
public class RewardController {
	@Autowired
	private RewardService rewardService = null;
	/**
	  * 查找所有成功奖励
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/rewardShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Reward> rewards = rewardService.getAllReward();
		 req.setAttribute("rewards", rewards);
		 req.getRequestDispatcher("./reward/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取成功奖励
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findRewardById")
	 public void findrewardById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Reward reward = rewardService.getRewardById(id);
		req.setAttribute("reward", reward);
		req.getRequestDispatcher("./reward/update.jsp").forward(req, rep);
	 }
	 /**
	  * 成功奖励赛事
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/rewardAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", GetID.getUUID());
		Integer i = Integer.valueOf(req.getParameter("award"));
		map.put("award", i);
		Reward reward =(Reward) AutomaticObjectUtil.newInstance(map, Reward.class);
		rewardService.addReward(reward);
		rep.sendRedirect("./rewardShow.action");
	}
	 /**
	  * 更新成功奖励
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/rewardUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Integer i = Integer.valueOf(req.getParameter("award"));
		map.put("award", i);
		Reward reward =(Reward) AutomaticObjectUtil.newInstance(map, Reward.class);
		rewardService.updateReward(reward);
		rep.sendRedirect("./rewardShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/rewardDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					rewardService.deleteReward(did);
				}
			}
		}else {
			rewardService.deleteReward(id);
		}
		rep.sendRedirect("./rewardShow.action");
	}
	@RequestMapping(value="/skipReward")
	public String skipreward() {
		return "../reward/add";
	}
}
