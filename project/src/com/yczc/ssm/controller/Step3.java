package com.yczc.ssm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yczc.ssm.util.WX_Util;


@Controller
public class Step3 {
	String appId = "wx9471acc7a0c59a6e";	
	String key="GPZULsQWa5kToVt37zXu4ysgErGojQbO";
	
	@RequestMapping(value = "/step3", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String step3(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		//
		String timeStamp = System.currentTimeMillis()+"";
		String nonceStr  = WX_Util.getRandomStr();
		String prepay_id = req.getParameter("prepay_id");
		if(prepay_id!=null){
			Map map = new HashMap();	
			map.put("appId", appId);
			map.put("timeStamp", timeStamp);
			map.put("nonceStr", nonceStr);
			map.put("package", "prepay_id="+prepay_id);
			map.put("signType", "MD5");
			
			BeanStep3 beanStep3 = new BeanStep3(timeStamp, nonceStr, WX_Util.sign(map, key));
			System.out.println("Step3   "+JSON.toJSONString(beanStep3));
			return JSON.toJSONString(beanStep3);
		}else{
			return JSON.toJSONString("-1");
		}
	}
}
