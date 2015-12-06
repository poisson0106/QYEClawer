package com.sjw.bookcapture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="loginInit",method=RequestMethod.GET)
	public ModelAndView initialOneUser(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	
	@RequestMapping(value="loginOneUser",method=RequestMethod.GET)
	public ModelAndView loginOneUser(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
