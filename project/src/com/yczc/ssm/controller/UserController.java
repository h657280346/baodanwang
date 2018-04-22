package com.yczc.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.yczc.ssm.pojo.Highlights;
import com.yczc.ssm.pojo.Interesting;
import com.yczc.ssm.pojo.Success;
import com.yczc.ssm.pojo.User;
import com.yczc.ssm.service.HighlightsService;
import com.yczc.ssm.service.InterestingService;
import com.yczc.ssm.service.PlanService;
import com.yczc.ssm.service.SuccessService;
import com.yczc.ssm.service.UserService;
import com.yczc.ssm.util.HttpRequestor;

@Controller
public class UserController {
	@Autowired
	private UserService userService = null;
	@Autowired
	private PlanService planService = null;
	@Autowired
	private InterestingService interestingService = null;
	@Autowired
	private SuccessService successService = null;
	@Autowired
	private HighlightsService highlightsService = null;
	private static ResourceBundle bundle = null;
	
	@RequestMapping(value="/viewAdd")
	public void addView(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Interesting interesting = interestingService.findInterestingById(id);
		
		if(interesting==null) {
			Highlights high = highlightsService.findHighlightsById(id);
			if(high==null) {
				Success success = successService.findSuccessById(id);
				if(success!=null) {
					successService.updateSuccessView(id);
				}
			}else {
				highlightsService.updateHighlightsView(id);
			}
		}else {
			interestingService.updateInterestingView(id);
		}
		
	}
	@RequestMapping(value="/index")
	 public void index(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		int planCount = planService.count();
		int interestingCount = interestingService.count();
		int successCount = successService.count();
		int highlights = highlightsService.count();
		int all = userService.count();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(d);
		int today = userService.count1(time);
		int today1 = userService.count1(sdf.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000)));
		int today2 = userService.count1(sdf.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000)));
		int today3 = userService.count1(sdf.format(new Date(d.getTime() - 3 * 24 * 60 * 60 * 1000)));
		int today4 = userService.count1(sdf.format(new Date(d.getTime() - 4 * 24 * 60 * 60 * 1000)));
		int today5 = userService.count1(sdf.format(new Date(d.getTime() - 5 * 24 * 60 * 60 * 1000)));
		int today6 = userService.count1(sdf.format(new Date(d.getTime() - 6 * 24 * 60 * 60 * 1000)));
		int three = userService.count3(sdf.format(new Date(d.getTime() - 3 * 24 * 60 * 60 * 1000)), time);
		int senven = userService.count3(sdf.format(new Date(d.getTime() - 6 * 24 * 60 * 60 * 1000)), time);
		req.setAttribute("today1",today1);
		req.setAttribute("today2",today2);
		req.setAttribute("today3",today3);
		req.setAttribute("today4",today4);
		req.setAttribute("today5",today5);
		req.setAttribute("today6",today6);
		
		req.setAttribute("all",all);
		req.setAttribute("today",today);
		req.setAttribute("three",three);
		req.setAttribute("senven",senven);
		req.setAttribute("plan",planCount);
		req.setAttribute("interesting",interestingCount);
		req.setAttribute("success",successCount);
		req.setAttribute("highlights",highlights);
		req.getRequestDispatcher("./index.jsp").forward(req, rep);
		
	 }
	
	
	@RequestMapping(value="/userShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<User> users = userService.findAllUser();
		 req.setAttribute("users", users);
		 req.getRequestDispatcher("./user/index.jsp").forward(req, rep);
		
	 
	}
	

	
	public static String codeConvert(String text){  
        String result = text;  
          
        try {  
            result = new String(text.getBytes("iso8859_1"), "utf-8");  
        } catch (Exception e) {  
            System.err.println("中文转码失败！");  
            e.printStackTrace();  
        }  
          
        return result;  
    }  
	
	 /**
	  * 保存案列
	  * @param file
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/userAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("utf-8");
		rep.setCharacterEncoding("utf-8");
		String code = req.getParameter("code");
		bundle = ResourceBundle.getBundle("conn");
        String appid = bundle.getString("appid");
        String secret = bundle.getString("secret");
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        //第一次请求 获取access_token 和 openid
        String  oppid = new HttpRequestor().doGet(requestUrl);
        JSONObject oppidObj =JSONObject.parseObject(oppid);
        String openid = (String) oppidObj.get("openid");
		String avatarUrl = null;
		String city = null;
		String province = null;
		String country = null;
		String gender = null;
		String nickName = null;
		String time = null;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		time = sdf.format(d);
		if(userService.findUserByIdAndTime(openid, time) == null) {
			
			avatarUrl = req.getParameter("avatarUrl");
			city = req.getParameter("city");
			province = req.getParameter("province");
			country = req.getParameter("country");
			gender = req.getParameter("gender");
			nickName = req.getParameter("nickname");
			nickName = codeConvert(nickName);
			if(gender.equals("0")) {
				gender = "未知";
			}else if(gender.equals("1")) {
				gender = "男";
			}else {
				gender = "女";
			}
			User user = new User();
			user.setAvatarUrl(avatarUrl);
			user.setCity(city);
			user.setCountry(country);
			user.setGender(gender);
			user.setNickName(nickName);
			user.setOpenId(openid);
			user.setProvince(province);
			user.setTime(time);
			userService.addUser(user);
		}
			
	}
	
	
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/userDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					userService.deleteUser(did);
				}
			}
		}else {
			userService.deleteUser(id);
		}
		rep.sendRedirect("./userShow.action");
	}

}
