package com.yczc.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.pojo.Plan;
import com.yczc.ssm.service.PlanService;
import com.yczc.ssm.util.GetID;

@Controller
public class PlanController {

	 @Autowired
	 private PlanService planService = null;
	 
	 
	 
	 
	 @RequestMapping(value="/planAll",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findAll() throws Exception {
		 List<Plan> planes = planService.findAllPlan();
		 return JSON.toJSONString(planes);
	 }
	 
	 @RequestMapping(value="/planId",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findId(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Plan plan = planService.findPlanById(id);
		return JSON.toJSONString(plan);
	 }
	 
	 
	 
	 @RequestMapping(value="/planShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Plan> plan = planService.findAllPlan();
		 req.setAttribute("plan", plan);
		 req.getRequestDispatcher("plan/index.jsp").forward(req, rep);
		
	 }
	 
	 /**
	  * 根据id获取案例
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findplanById")
	 public void findPlanById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Plan plan = planService.findPlanById(id);
		req.setAttribute("plan", plan);
		System.out.println(plan.getId());
		req.getRequestDispatcher("./plan/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存案列
	  * @param file
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/planAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("utf-8");
		rep.setCharacterEncoding("utf-8");
		String id = null;
		String company = null;
		String tele = null;
		String man = null;
		String main = null;
		String require = null;
		String time = null;
		id = GetID.getUUID();
		company = req.getParameter("company");
		tele = req.getParameter("tel");
		man = req.getParameter("name");
		main = req.getParameter("view");
		require = req.getParameter("people");
		time = req.getParameter("time");
		Plan plan = new Plan();
		plan.setId(id);
		plan.setCompany(company);
		plan.setMain(main);
		plan.setMan(man);
		plan.setRequires(require);
		plan.setTele(tele);
		plan.setTime(time);
		planService.addPlan(plan);
	}
	
	
	/**
	 * 更新案列
	 * @param file
	 * @param req
	 * @param rep
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/planUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		String company = null;
		String tele = null;
		String man = null;
		String main = null;
		String require = null;
		String time = null;
		id = req.getParameter("id");
		company = req.getParameter("company");
		tele = req.getParameter("tele");
		man = req.getParameter("man");
		main = req.getParameter("main");
		require = req.getParameter("require");
		time = req.getParameter("time");
		Plan plan = new Plan();
		plan.setId(id);
		plan.setCompany(company);
		plan.setMain(main);
		plan.setMan(man);
		plan.setRequires(require);
		plan.setTele(tele);
		plan.setTime(time+"");
		planService.updatePlan(plan);
		rep.sendRedirect("./planShow.action");
	}
	
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/planDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					planService.deletePlan(did);
				}
			}
		}else {
			planService.deletePlan(id);
		}
		rep.sendRedirect("./planShow.action");
	}


}
