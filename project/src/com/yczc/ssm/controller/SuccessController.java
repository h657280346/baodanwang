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
import com.alibaba.fastjson.JSONObject;
import com.yczc.ssm.pojo.Success;
import com.yczc.ssm.service.SuccessService;
import com.yczc.ssm.util.Address;
import com.yczc.ssm.util.GetID;

@Controller
public class SuccessController {

	 @Autowired
	 private ServletContext servletContext;
	 @Autowired
	 private SuccessService successService = null;
	 
	 @RequestMapping(value="/successAll",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findAll() throws Exception {
		 List<Success> successes = successService.findAllSuccess();
		 return JSON.toJSONString(successes);
	 }
	 
	 @RequestMapping(value="/successId",produces="text/html;charset=UTF-8")
	 public @ResponseBody JSONObject findId(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Success success = successService.findSuccessById(id);
		JSON.toJSON(success);
		return (JSONObject) JSON.toJSON(success);
	 }
	 /**
	  * 查找所有案列
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/successShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Success> successes = successService.findAllSuccess();
		 req.setAttribute("successes", successes);
		 req.getRequestDispatcher("./success/index.jsp").forward(req, rep);
		
	 }
	 
	 /**
	  * 根据id获取案例
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findSuccessById")
	 public void findSuccessById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Success success = successService.findSuccessById(id);
		req.setAttribute("success", success);
		req.getRequestDispatcher("./success/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存案列
	  * @param file
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/successAdd")
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
			priority = Integer.parseInt(req.getParameter("priority"));
			author = req.getParameter("author");
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			id = GetID.getUUID();
			title = req.getParameter("title");
			introduction = req.getParameter("introduction");
			introduction = introduction.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
			time = sdf.format(d);
			Success success = new Success();
			success.setId(id);
			success.setIntroduction(introduction);
			success.setPicture(path);
			success.setTitle(title);
			success.setTime(time);
			success.setAuthor(author);
			success.setFigure(fig);
			success.setPriority(priority);
			successService.addSuccess(success);
		}
		rep.sendRedirect("./successShow.action");
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
                path = ResourceBundle.getBundle("conn").getString("savepath")+ "\\upload\\img\\"+time+"."+later;
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
	@RequestMapping(value="/successUpdate")
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
		priority = Integer.parseInt(req.getParameter("priority"));
		author = req.getParameter("author");
		id = req.getParameter("id");
		title = req.getParameter("title");
		introduction = req.getParameter("introduction");
		introduction = introduction.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		Success success = new Success();
		success.setId(id);
		success.setIntroduction(introduction);
		success.setPicture(path);
		success.setTitle(title);
		success.setAuthor(author);
		success.setFigure(fig);
		success.setPriority(priority);
		successService.updateSuccess(success);
		rep.sendRedirect("./successShow.action");
	}
	
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/successDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					successService.deleteSuccess(did);
				}
			}
		}else {
			successService.deleteSuccess(id);
		}
		rep.sendRedirect("./successShow.action");
	}
}
