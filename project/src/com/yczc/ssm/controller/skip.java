package com.yczc.ssm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yczc.ssm.pojo.Figure;

@Controller
public class skip {
	

	@RequestMapping(value="/skipSuccess")
	public String skipSuccess() {
		return "../success/add";
	}
	@RequestMapping(value="/skipPlan")
	public String skipPlan() {
		return "../plan/add";
	}
	@RequestMapping(value="/skipInteresting")
	public String skipInteresting() {
		return "../interesting/add";
	}
	@RequestMapping(value="/skipHighlights")
	public String skipHighlights() {
		return "../highlights/add";
	}
	@RequestMapping(value="/skipContact")
	public String skipContact() {
		return "../contact/add";
	}
	
	@RequestMapping(value="/pass")
	public String skipPass() {
		return "../password/update";
	}
	
}
