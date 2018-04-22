package com.yczc.ssm.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.yczc.ssm.pojo.Ballteam;
import com.yczc.ssm.service.BallteamService;
import com.yczc.ssm.util.Address;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 球队
 * @author liu_yeye
 *
 */
@Controller
public class BallteamController {
	@Autowired
	private BallteamService ballteamService = null;
	/**
	  * 查找所有球队
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/ballteamShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Ballteam> ballteams = ballteamService.getAllBallteam();
		 req.setAttribute("ballteams", ballteams);
		 req.getRequestDispatcher("./ballteam/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取球队
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findBallteamById")
	 public void findBallteamById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Ballteam ballteam = ballteamService.getBallteamById(id);
		req.setAttribute("ballteam", ballteam);
		req.getRequestDispatcher("./ballteam/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存球队 
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/ballteamAdd")
	public void add(@RequestParam("teamimg") MultipartFile teamimg,HttpServletRequest req,HttpServletResponse rep) throws Exception {
	   
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Ballteam.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(), GetID.getUUID());
			}else if(entry.getKey().equals("teamimg")){
				String s = saveFile(teamimg);
					map.put(entry.getKey(),s);	
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Ballteam ballteam =(Ballteam) AutomaticObjectUtil.newInstance(map, Ballteam.class);
		ballteamService.addBallteam(ballteam);
		rep.sendRedirect("./ballteamShow.action");
	}
	/**
	 * 保存上传文件
	 * @param file
	 * @return
	 */
	private String saveFile(MultipartFile file) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
       String path = null;
       String basePath = "/upload" ;
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
               path = request.getSession().getServletContext().getRealPath("/"+basePath+"/");
               path+= "/img/"+time+"."+later;
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
	  * 更新球队
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/ballteamUpdate")
	public void update(@RequestParam("teamimg") MultipartFile teamimg,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Ballteam.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(),  req.getParameter(entry.getKey()));
			}else if(entry.getKey().equals("teamimg")){
				String s = saveFile(teamimg);
				if(s==null){
					s = req.getParameter("old-teamimg");
				}
				map.put(entry.getKey(),s);	
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Ballteam ballteam =(Ballteam) AutomaticObjectUtil.newInstance(map, Ballteam.class);
		ballteamService.updateBallteam(ballteam);
		rep.sendRedirect("./ballteamShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/ballteamDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					ballteamService.deleteBallteam(did);
				}
			}
		}else {
			ballteamService.deleteBallteam(id);
		}
		rep.sendRedirect("./ballteamShow.action");
	}
	@RequestMapping(value="/skipBallteam")
	public String skipBallteam() {
		return "../ballteam/add";
	}

}
