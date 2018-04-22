package com.yczc.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.yczc.ssm.pojo.Yuezhan;
import com.yczc.ssm.pojo.Yuezhan;
import com.yczc.ssm.service.YuezhanService;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 约战
 * @author liu_yeye
 *
 */
@Controller
public class YuezhanController {
	@Autowired
	private YuezhanService yuezhanService=null;
	/**
	  * 查找所有约战
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/yuezhanShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Yuezhan> yuezhans = yuezhanService.getAllYuezhan();
		 req.setAttribute("yuezhans", yuezhans);
		 req.getRequestDispatcher("./yuezhan/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取约战
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findYuezhanById")
	 public void findYuezhanById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Yuezhan yuezhan = yuezhanService.getYuezhanById(id);
		req.setAttribute("yuezhan", yuezhan);
		req.getRequestDispatcher("./yuezhan/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存约战
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/yuezhanAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
	   
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Yuezhan.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(), GetID.getUUID());
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Yuezhan yuezhan =(Yuezhan) AutomaticObjectUtil.newInstance(map, Yuezhan.class);
		yuezhanService.addYuezhan(yuezhan);
		rep.sendRedirect("./yuezhanShow.action");
	}
	 /**
	  * 更新约战
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/yuezhanUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Yuezhan.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(),  req.getParameter(entry.getKey()));
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Yuezhan yuezhan =(Yuezhan) AutomaticObjectUtil.newInstance(map, Yuezhan.class);
		yuezhanService.updateYuezhan(yuezhan);
		rep.sendRedirect("./yuezhanShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/yuezhanDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					yuezhanService.deleteYuezhan(did);
				}
			}
		}else {
			yuezhanService.deleteYuezhan(id);
		}
		rep.sendRedirect("./yuezhanShow.action");
	}
	@RequestMapping(value="/skipYuezhan")
	public String skipYuezhan() {
		return "../yuezhan/add";
	}
}
