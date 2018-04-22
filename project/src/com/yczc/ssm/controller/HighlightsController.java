package com.yczc.ssm.controller;

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
import com.yczc.ssm.pojo.Highlights;
import com.yczc.ssm.service.HighlightsService;
import com.yczc.ssm.util.Address;
import com.yczc.ssm.util.GetID;

@Controller
public class HighlightsController {



	 @Autowired
	 private ServletContext servletContext;
	 @Autowired
	 private HighlightsService highlightsService = null;
	 
	 @RequestMapping(value="/highlightsAll",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findAll() throws Exception {
		 List<Highlights> highlightses = highlightsService.findAllHighlights();
		 return JSON.toJSONString(highlightses);
	 }
	 
	 @RequestMapping(value="/highlightsId",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findId(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Highlights highlights = highlightsService.findHighlightsById(id);
		return JSON.toJSONString(highlights);
	 }
	 /**
	  * 查找所有案列
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/highlightsShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Highlights> highlightses = highlightsService.findAllHighlights();
		 req.setAttribute("highlightses", highlightses);
		 req.getRequestDispatcher("highlights/index.jsp").forward(req, rep);
		
	 }
	 
	 /**
	  * 根据id获取案例
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findHighlightsById")
	 public void findHighlightsById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Highlights highlights = highlightsService.findHighlightsById(id);
		req.setAttribute("highlights", highlights);
		req.getRequestDispatcher("./highlights/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存案列
	  * @param file
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/highlightsAdd")
	public void add(@RequestParam("myPhoto") MultipartFile file,@RequestParam("video") MultipartFile video,@RequestParam("figure") MultipartFile figure,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String path = null;
		String id = null;
		String title = null;
		String videoPath = null;
		String time = null;
		String introduction = null;
		int priority = 0;
		String author = null;
		String fig = saveFile(figure,"img");
		videoPath = saveFile(video, "video");
		path = saveFile(file,"img");
		
		if(path==null) {
			
		}else {
			introduction = req.getParameter("introduction");
			introduction = introduction.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			id = GetID.getUUID();
			title = req.getParameter("title");
			priority = Integer.parseInt(req.getParameter("priority"));
			author = req.getParameter("author");
			if(videoPath==null) {
				videoPath = req.getParameter("videourl");
			}
			time = sdf.format(d);
			Highlights highlights = new Highlights();
			highlights.setId(id);
			highlights.setVideo(videoPath);
			highlights.setPicture(path);
			highlights.setTitle(title);
			highlights.setTime(time);
			highlights.setIntroduction(introduction);
			highlights.setAuthor(author);
			highlights.setFigure(fig);
			highlights.setPriority(priority);
			highlightsService.addHighlights(highlights);
		}
		rep.sendRedirect("./highlightsShow.action");
	}
	/**
	 * 保存上传文件
	 * @param file
	 * @return
	 */
	private String saveFile(MultipartFile file,String type) {
      String path = null;
      String location = "/upload/"+type+"/";
		if (!file.isEmpty()) {
          try {
          	StringTokenizer st = new StringTokenizer(file.getOriginalFilename(), ".");
          	String later = null;
          	while(st.hasMoreTokens()) {
          		later = st.nextToken();
          	}
          	String time = System.currentTimeMillis()+"";
              path = ResourceBundle.getBundle("conn").getString("savepath")+"\\upload\\"+type+"\\"+time+"."+later;
              
              System.out.println(path);
              FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
              System.out.println(path);
              path = Address.address + location+time+"."+later;
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
	@RequestMapping(value="/highlightsUpdate")
	public void update(@RequestParam("myPhoto") MultipartFile file,@RequestParam("video") MultipartFile video,@RequestParam("figure") MultipartFile figure,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String path = null;
		String id = null;
		String title = null;
		String videoPath = null;
		String introduction = null;
		int priority = 0;
		String author = null;
		String fig = saveFile(figure,"img");
		videoPath = saveFile(video, "video");
		path = saveFile(file,"img");
		if(path==null) {
			path = req.getParameter("picture");
		}
		if(videoPath==null) {
			videoPath = req.getParameter("videourl");
			if(videoPath==null||videoPath.equals("")) {
				videoPath = req.getParameter("videoPath");
			}
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
		introduction = req.getParameter("introduction");
		introduction = introduction.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		title = req.getParameter("title");
		Highlights highlights = new Highlights();
		highlights.setId(id);
		highlights.setVideo(videoPath);
		highlights.setPicture(path);
		highlights.setTitle(title);
		highlights.setIntroduction(introduction);
		highlights.setAuthor(author);
		highlights.setFigure(fig);
		highlights.setPriority(priority);
		highlightsService.updateHighlights(highlights);
		rep.sendRedirect("./highlightsShow.action");
	}
	
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/highlightsDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					highlightsService.deleteHighlights(did);
				}
			}
		}else {
			highlightsService.deleteHighlights(id);
		}
		rep.sendRedirect("./highlightsShow.action");
	}

}
