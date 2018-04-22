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

import com.yczc.ssm.pojo.Subscriber;
import com.yczc.ssm.service.SubscriberService;
import com.yczc.ssm.util.Address;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 用户
 * @author liu_yeye
 *
 */
@Controller
public class SubscriberController {
	@Autowired
	private SubscriberService subscriberService = null;
	/**
	  * 查找所有用户
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/subscriberShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Subscriber> subscribers = subscriberService.getAllSubscriber();
		 req.setAttribute("subscribers", subscribers);
		 req.getRequestDispatcher("./subscriber/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取用户
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findSubscriberById")
	 public void findSubscriberById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Subscriber subscriber = null;
		String id = req.getParameter("id");
		if(id!=null && !id.equals("")){
			subscriber = subscriberService.getSubscriberById(id);
		}
		String openid = req.getParameter("openid");
		if(openid!=null && !openid.equals("")){
			subscriber = subscriberService.getSubscriberByOpenId(openid);
		}
		req.setAttribute("subscriber", subscriber);
		req.getRequestDispatcher("./subscriber/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存用户
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/subscriberAdd")
	public void add(@RequestParam("avatar") MultipartFile avatar,HttpServletRequest req,HttpServletResponse rep) throws Exception {
	   
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Subscriber.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(), GetID.getUUID());
			}else if(entry.getKey().equals("avatar")){
				String s = saveFile(avatar);
					map.put(entry.getKey(),s);	
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Subscriber subscriber =(Subscriber) AutomaticObjectUtil.newInstance(map, Subscriber.class);
		subscriberService.addSubscriber(subscriber);
		rep.sendRedirect("./subscriberShow.action");
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
	  * 更新用户
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/subscriberUpdate")
	public void update(@RequestParam("avatar") MultipartFile avatar,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Subscriber.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(),  req.getParameter(entry.getKey()));
			}else if(entry.getKey().equals("avatar")){
				String s = saveFile(avatar);
				if(s==null){
					s = req.getParameter("old-avatar");
				}
				map.put(entry.getKey(),s);	
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Subscriber subscriber =(Subscriber) AutomaticObjectUtil.newInstance(map, Subscriber.class);
		subscriberService.updateSubscriber(subscriber);
		rep.sendRedirect("./subscriberShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/subscriberDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					subscriberService.deleteSubscriber(did);
				}
			}
		}else {
			subscriberService.deleteSubscriber(id);
		}
		rep.sendRedirect("./subscriberShow.action");
	}
	@RequestMapping(value="/skipSubscriber")
	public String skipSubscriber() {
		return "../subscriber/add";
	}

}
