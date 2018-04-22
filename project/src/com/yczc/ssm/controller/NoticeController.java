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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.pojo.Carousel;
import com.yczc.ssm.pojo.Notice;
import com.yczc.ssm.service.NoticeService;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 公告
 * @author liu_yeye
 *
 */
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService=null;
	/**
	  * 查找所有公告
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/noticeShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Notice> notices = noticeService.findAllNotice();
		 req.setAttribute("notices", notices);
		 req.getRequestDispatcher("./notice/index.jsp").forward(req, rep);
	 }

	 /**
	  * 根据id获取公告
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findNoticeById")
	 public void findNoticeById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Notice notice = noticeService.findNoticeById(id);
		req.setAttribute("notice", notice);
		req.getRequestDispatcher("./notice/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存公告
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/noticeAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = GetID.getUUID();
		String title = req.getParameter("title");
		String introduce = req.getParameter("introduce");
		introduce = introduce.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		Integer priority = Integer.valueOf(req.getParameter("priority"));
		String videourl = req.getParameter("videourl");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("title", title);
		map.put("introduce", introduce);
		map.put("priority", priority);
		map.put("videourl", videourl);
		Notice notice = (Notice) AutomaticObjectUtil.newInstance(map, Notice.class);
		noticeService.addNotice(notice);
		rep.sendRedirect("./noticeShow.action");
	}
	 /**
	  * 更新公告
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/noticeUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String introduce = req.getParameter("introduce");
		introduce = introduce.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		Integer priority = Integer.valueOf(req.getParameter("priority"));
		String videourl = req.getParameter("videourl");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("title", title);
		map.put("introduce", introduce);
		map.put("priority", priority);
		map.put("videourl", videourl);
		Notice notice = (Notice) AutomaticObjectUtil.newInstance(map, Notice.class);
		noticeService.updateNotice(notice);
		rep.sendRedirect("./noticeShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/noticeDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					noticeService.deleteNotice(did);
				}
			}
		}else {
			noticeService.deleteNotice(id);
		}
		rep.sendRedirect("./noticeShow.action");
	}
	@RequestMapping(value="/skipNotice")
	public String skipNotice() {
		return "../notice/add";
	}
	
}
