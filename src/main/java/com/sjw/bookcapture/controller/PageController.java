package com.sjw.bookcapture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@Autowired
	ModelAndView mv;
	
	@RequestMapping(value="form",method=RequestMethod.GET)
	public ModelAndView getFormPage(){
		mv.setViewName("form");
		return mv;
	}
	
	@RequestMapping(value="services",method=RequestMethod.GET)
	public ModelAndView getSevicePage(){
		mv.setViewName("services");
		return mv;
	}
}
