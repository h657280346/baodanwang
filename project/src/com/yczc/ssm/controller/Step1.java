package com.yczc.ssm.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.controller.BeanStep1;
import com.yczc.ssm.util.WX_Util;

@Controller
public class Step1{
	private String appid = "wx9471acc7a0c59a6e";	
	private String secret = "9b47850ad9473eb17363b16595c8d5e8";
	@RequestMapping(value="/step1",produces="text/html;charset=UTF-8")
	public @ResponseBody String step1(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String js_code=req.getParameter("code");
		if(js_code!=null){
		BeanStep1 beanStep1 = WX_Util.step1(appid, secret, js_code);
		System.out.println("Step1   "+JSON.toJSONString(beanStep1));
		return JSON.toJSONString(beanStep1);
		}else{
			return JSON.toJSONString("-1");
		}
	}
}
