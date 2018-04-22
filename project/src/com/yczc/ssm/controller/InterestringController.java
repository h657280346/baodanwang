package com.yczc.ssm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.pojo.Interesting;
import com.yczc.ssm.service.InterestingService;
import com.yczc.ssm.util.Address;
import com.yczc.ssm.util.GetID;

@Controller
public class InterestringController {


	 @Autowired
	 private ServletContext servletContext;
	 @Autowired
	 private InterestingService interestingService = null;
	 
	 
	 
	 
	 @RequestMapping(value="/interestingAll",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findAll() throws Exception {
		 List<Interesting> interestinges = interestingService.findAllInteresting();
		 return JSON.toJSONString(interestinges);
	 }
	 
	 @RequestMapping(value="/interestingId",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findId(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Interesting interesting = interestingService.findInterestingById(id);
		return JSON.toJSONString(interesting);
	 }
	 
	 
	 
	 /**
	  * 查找所有案列
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/interestingShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Interesting> interestinges = interestingService.findAllInteresting();
		 req.setAttribute("interestings", interestinges);
		 req.getRequestDispatcher("./interesting/index.jsp").forward(req, rep);
		
	 }
	 
	 /**
	  * 根据id获取案例
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findInterestingById")
	 public void findInterestingById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Interesting interesting = interestingService.findInterestingById(id);
		req.setAttribute("interesting", interesting);
		req.getRequestDispatcher("./interesting/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存案列
	  * @param file
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/interestingAdd")
	public void add(@RequestParam("myPhoto") MultipartFile file,@RequestParam("figure") MultipartFile figure,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String path = null;
		String id = null;
		String title = null;
		String introduction = null;
		String time = null;
		int priority = 0;
		String author = null;
		path = saveFile(file);
		String fig = saveFile(figure);
		
		if(path==null) {
			
		}else {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			id = GetID.getUUID();
			title = req.getParameter("title");
			priority = Integer.parseInt(req.getParameter("priority"));
			author = req.getParameter("author");
			time = sdf.format(d);
			introduction = req.getParameter("introduction");
			introduction = introduction.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
			Interesting interesting = new Interesting();
			interesting.setId(id);
			interesting.setIntroduction(introduction);
			interesting.setPicture(path);
			interesting.setTitle(title);
			interesting.setTime(time);
			interesting.setAuthor(author);
			interesting.setFigure(fig);
			interesting.setPriority(priority);
			interestingService.addInteresting(interesting);
		}
		rep.sendRedirect("./interestingShow.action");
	}
	/**
	 * 保存上传文件
	 * @param file
	 * @return
	 */
	private String saveFile(MultipartFile file) {
       String path = null;
		if (!file.isEmpty()) {
           try {
           	StringTokenizer st = new StringTokenizer(file.getOriginalFilename(), ".");
           	String later = null;
           	while(st.hasMoreTokens()) {
           		later = st.nextToken();
           	}
           	String time = System.currentTimeMillis()+"";
               path = ResourceBundle.getBundle("conn").getString("savepath") + "\\upload\\img\\"+time+"."+later;
               FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
               path = Address.address + "/upload/img/"+time+"."+later;
               return path;
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return null;
   }
	
	/**
	 * 更新案列
	 * @param file
	 * @param req
	 * @param rep
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/interestingUpdate")
	public void update(@RequestParam("myPhoto") MultipartFile file,@RequestParam("figure") MultipartFile figure,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String path = null;
		String id = null;
		String title = null;
		String introduction = null;
		int priority = 0;
		String author = null;
		path = saveFile(file);
		String fig = saveFile(figure);
		
		if(path==null) {
			path = req.getParameter("picture");
		}
		if(fig==null) {
			fig = req.getParameter("fig");
		}
		if(req.getParameter("flag").equals("no")) {
			fig=null;
		}
		id = req.getParameter("id");
		priority = Integer.parseInt(req.getParameter("priority"));
		author = req.getParameter("author");
		title = req.getParameter("title");
		introduction = req.getParameter("introduction");
		introduction = introduction.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		Interesting interesting = new Interesting();
		interesting.setId(id);
		interesting.setIntroduction(introduction);
		interesting.setPicture(path);
		interesting.setTitle(title);
		interesting.setAuthor(author);
		interesting.setFigure(fig);
		interesting.setPriority(priority);
		interestingService.updateInteresting(interesting);
		rep.sendRedirect("./interestingShow.action");
	}
	
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/interestingDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					interestingService.deleteInteresting(did);
				}
			}
		}else {
			interestingService.deleteInteresting(id);
		}
		rep.sendRedirect("./interestingShow.action");
	}


}
