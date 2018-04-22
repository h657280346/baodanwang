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

import com.yczc.ssm.pojo.About;
import com.yczc.ssm.service.AboutService;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;


/**
 * 关于
 * @author liu_yeye
 *
 */
@Controller
public class AboutController {
	@Autowired
	private AboutService aboutService = null;
	/**
	  * 查找所有关于
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/aboutShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<About> abouts = aboutService.getAllAbout();
		 req.setAttribute("abouts", abouts);
		 req.getRequestDispatcher("./about/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取关于
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findAboutById")
	 public void findaboutById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		About about = aboutService.getAboutById(id);
		req.setAttribute("about", about);
		req.getRequestDispatcher("./about/update.jsp").forward(req, rep);
	 }
	 /**
	  * 增加关于
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/aboutAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", GetID.getUUID());
		map.put("content", req.getParameter("content"));
		About about =(About) AutomaticObjectUtil.newInstance(map, About.class);
		aboutService.addAbout(about);
		rep.sendRedirect("./aboutShow.action");
	}
	 /**
	  * 更新关于
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/aboutUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("content", req.getParameter("content"));
		About about =(About) AutomaticObjectUtil.newInstance(map, About.class);
		aboutService.updateAbout(about);
		rep.sendRedirect("./aboutShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/aboutDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					aboutService.deleteAbout(did);
				}
			}
		}else {
			aboutService.deleteAbout(id);
		}
		rep.sendRedirect("./aboutShow.action");
	}
	@RequestMapping(value="/skipAbout")
	public String skipabout() {
		return "../about/add";
	}
}

