package com.ideyatech.hellospring.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	@ResponseBody
	public String home() {
		return "Hello World!";
	}
	
	@RequestMapping(value="/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "Hello Message");
		return "welcome";
	}
	
	public ModelAndView processResume(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
