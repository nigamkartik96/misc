package com.kartik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Action {
	@RequestMapping("sendData")
	public ModelAndView sendData(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("_csrf") String token) {
		System.out.println(token);
		System.out.println(username + " kartik " + password);
		return new ModelAndView("welcome");
	}

	@RequestMapping("403")
	public ModelAndView sendData(Exception e) {
		return new ModelAndView("403");
	}
}
