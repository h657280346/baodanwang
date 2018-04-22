package com.yczc.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.pojo.Contact;
import com.yczc.ssm.service.ContactService;

@Controller
public class ContactController {

	 @Autowired
	 private ContactService contactService = null;
	 
	 @RequestMapping(value="/contactAll",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findAll() throws Exception {
		 List<Contact> contact = contactService.findAllContact();
		 return JSON.toJSONString(contact);
	 }
	 
	 
	 /**
	  * 查找所有案列
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/contactShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Contact> contact = contactService.findAllContact();
		 req.setAttribute("contact", contact);
		 req.getRequestDispatcher("contact/update.jsp").forward(req, rep);
		
	 }
	 @RequestMapping(value="/contactUpdate")
		public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
			String tel = null;
			String id = null;
			id = req.getParameter("id");
			tel = req.getParameter("tel");
			Contact contact = new Contact();
			contact.setId(id);
			contact.setTel(tel);
			contactService.updateContact(contact);
			rep.sendRedirect("./contactShow.action");
		}
		
		
	 
}
