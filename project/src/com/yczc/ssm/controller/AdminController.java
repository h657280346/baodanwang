package com.yczc.ssm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yczc.ssm.pojo.Admin;
import com.yczc.ssm.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	 private AdminService adminService = null;
	@RequestMapping("/login")
	public void login(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Admin admin = adminService.findAdmin(username, password);
		
		if(admin!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			req.getRequestDispatcher("./index.action").forward(req, rep);
		}else {
			req.setAttribute("error","用户名或密码错误");
			req.getRequestDispatcher("./login.jsp").forward(req, rep);
		}
	}
	
	@RequestMapping("/updatePass")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		String pass1 = req.getParameter("pass1");
		String pass2 = req.getParameter("pass2");
		Admin admin = adminService.findAdmin(username, pass);
		if(!pass1.equals(pass2)) {
			req.setAttribute("error","两次密码不一致");
			req.getRequestDispatcher("./pass.action").forward(req, rep);
		}
		else if(admin!=null) {
			admin.setPassword(pass1);
			adminService.updatePass(admin);
			req.getRequestDispatcher("./index.action").forward(req, rep);
		}else {
			req.setAttribute("error","原密码错误");
			req.getRequestDispatcher("./pass.action").forward(req, rep);
		}
	}
	
	@RequestMapping("/loginOut")  
    public void clientLoginOut(HttpServletRequest req,HttpServletResponse rep,HttpSession httpSession) throws ServletException, IOException{  
        httpSession.invalidate();  
        req.getRequestDispatcher("./login.jsp").forward(req, rep);
	} 
}
