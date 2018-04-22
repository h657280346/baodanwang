package com.yczc.ssm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yczc.ssm.controller.Service;
import com.yczc.ssm.pojo.Admin;

public class LoginHandlerIntercepter implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		String requestURI = request.getRequestURI();  
		for(String url:Service.url){
			if(requestURI.indexOf(url)>0){
				return true;
			}
		}
		if(requestURI.indexOf("login.action")>0){
        	return true;
        }
		if(requestURI.indexOf("viewAdd.action")>0){
        	return true;
        }
		if(requestURI.indexOf("planAdd.action")>0){
        	return true;
        }
		if(requestURI.indexOf("figureAll.action")>0){
        	return true;
        }
		if(requestURI.indexOf("highlightsAll.action")>0){
        	return true;
        }
		if(requestURI.indexOf("userAdd.action")>0){
        	return true;
        }
		if(requestURI.indexOf("interestingAll.action")>0){
        	return true;
        }
		if(requestURI.indexOf("contactAll.action")>0){
        	return true;
        }
		if(requestURI.indexOf("planAll.action")>0){
        	return true;
        }
		if(requestURI.indexOf("successAll.action")>0){
        	return true;
        }
		if(requestURI.indexOf("userAdd.action")>0){
        	return true;
        }
		if(requestURI.indexOf("planId.action")>0){
        	return true;
        }
		else{  
        	  
            HttpSession session = request.getSession();  
            Admin admin = (Admin) session.getAttribute("admin");  
            if(admin!=null){  
                //登陆成功的用户  
                return true;  
            }else{  
               //没有登陆，转向登陆界面  
                request.getRequestDispatcher("/login.jsp").forward(request,arg1);  
              return false;  
            }  
          
        }  
	}

}
