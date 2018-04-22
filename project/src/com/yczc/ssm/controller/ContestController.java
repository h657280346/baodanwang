package com.yczc.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yczc.ssm.pojo.Contest;
import com.yczc.ssm.pojo.Contest;
import com.yczc.ssm.service.ContestService;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 赛事
 * @author liu_yeye
 *
 */
@Controller
public class ContestController {
	@Autowired
	private ContestService contestService = null;
	
	@RequestMapping(value="/yzsteamindex")
	 public void index(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		int noticeCount = Service.noticeService.count();
		int carouselCount = Service.carouselService.count();
		int commentCount = Service.commentService.count();
		int successCount = Service.yuezhanService.count();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(d);
		int contestCount = Service.contestService.count();
		int today = contestService.count1(time);
		int today1 = contestService.count1(sdf.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000)));
		int today2 = contestService.count1(sdf.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000)));
		int today3 = contestService.count1(sdf.format(new Date(d.getTime() - 3 * 24 * 60 * 60 * 1000)));
		int today4 = contestService.count1(sdf.format(new Date(d.getTime() - 4 * 24 * 60 * 60 * 1000)));
		int today5 = contestService.count1(sdf.format(new Date(d.getTime() - 5 * 24 * 60 * 60 * 1000)));
		int today6 = contestService.count1(sdf.format(new Date(d.getTime() - 6 * 24 * 60 * 60 * 1000)));
		int three = contestService.count3(sdf.format(new Date(d.getTime() - 3 * 24 * 60 * 60 * 1000)), time);
		int senven = contestService.count3(sdf.format(new Date(d.getTime() - 6 * 24 * 60 * 60 * 1000)), time);
		req.setAttribute("today1",today1);
		req.setAttribute("today2",today2);
		req.setAttribute("today3",today3);
		req.setAttribute("today4",today4);
		req.setAttribute("today5",today5);
		req.setAttribute("today6",today6);
		req.setAttribute("contestCount",contestCount);
		req.setAttribute("today",today);
		req.setAttribute("three",three);
		req.setAttribute("senven",senven);
		req.setAttribute("noticeCount",noticeCount);
		req.setAttribute("carouselCount",carouselCount);
		req.setAttribute("commentCount",commentCount);
		req.setAttribute("successCount",successCount);
		req.getRequestDispatcher("./yuezhanindex.jsp").forward(req, rep);
		
	 }
	
	/**
	  * 查找所有赛事
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/contestShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Contest> contests = contestService.getAllContest();
		 req.setAttribute("contests", contests);
		 req.getRequestDispatcher("./contest/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取赛事
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findContestById")
	 public void findcontestById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Contest contest = contestService.getContestById(id);
		req.setAttribute("contest", contest);
		req.getRequestDispatcher("./contest/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存赛事
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/contestAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
	   
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", GetID.getUUID());
		map.put("pteamid", req.getParameter("pteamid"));
		map.put("mteamid", req.getParameter("mteamid"));
		map.put("popenid", req.getParameter("popenid"));
		map.put("mopenid", req.getParameter("mopenid"));
		map.put("date", req.getParameter("date"));
		map.put("week", req.getParameter("week"));
		map.put("time", req.getParameter("time"));
		map.put("postdate", req.getParameter("postdate"));
		map.put("lng", req.getParameter("lng"));
		map.put("lat", req.getParameter("lat"));
		map.put("adress", req.getParameter("adress"));
		map.put("contact", req.getParameter("contact"));
		Integer person = Integer.valueOf(req.getParameter("person"));
		map.put("person", person);
		map.put("clothing", req.getParameter("clothing"));
		map.put("turf", req.getParameter("turf"));
		map.put("cost", req.getParameter("cost"));
		Integer ensure = Integer.valueOf(req.getParameter("ensure"));
		map.put("ensure",ensure);
		Integer award = Integer.valueOf(req.getParameter("award"));
		map.put("award", award);
		String notes = req.getParameter("notes");
		notes = notes.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		map.put("notes", notes);
		map.put("status", req.getParameter("status"));
		map.put("reasons", req.getParameter("reasons"));
		Contest contest =(Contest) AutomaticObjectUtil.newInstance(map, Contest.class);
		contestService.addContest(contest);
		rep.sendRedirect("./contestShow.action");
	}
	 /**
	  * 更新赛事
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/contestUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pteamid", req.getParameter("pteamid"));
		map.put("mteamid", req.getParameter("mteamid"));
		map.put("popenid", req.getParameter("popenid"));
		map.put("mopenid", req.getParameter("mopenid"));
		map.put("date", req.getParameter("date"));
		map.put("week", req.getParameter("week"));
		map.put("time", req.getParameter("time"));
		map.put("postdate", req.getParameter("postdate"));
		map.put("lng", req.getParameter("lng"));
		map.put("lat", req.getParameter("lat"));
		map.put("adress", req.getParameter("adress"));
		map.put("contact", req.getParameter("contact"));
		Integer person = Integer.valueOf(req.getParameter("person"));
		map.put("person", person);
		map.put("clothing", req.getParameter("clothing"));
		map.put("turf", req.getParameter("turf"));
		map.put("cost", req.getParameter("cost"));
		Integer ensure = Integer.valueOf(req.getParameter("ensure"));
		map.put("ensure",ensure);
		Integer award = Integer.valueOf(req.getParameter("award"));
		map.put("award", award);
		String notes = req.getParameter("notes");
		notes = notes.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		map.put("notes", notes);
		map.put("status", req.getParameter("status"));
		map.put("reasons", req.getParameter("reasons"));
		Contest contest =(Contest) AutomaticObjectUtil.newInstance(map, Contest.class);
		contestService.updateContest(contest);
		rep.sendRedirect("./contestShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/contestDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					contestService.deleteContest(did);
				}
			}
		}else {
			contestService.deleteContest(id);
		}
		rep.sendRedirect("./contestShow.action");
	}
	@RequestMapping(value="/skipContest")
	public String skipcontest() {
		return "../contest/add";
	}

}
