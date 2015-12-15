package com.sjw.bookcapture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjw.bookcapture.pojo.ZhihuPojo;
import com.sjw.bookcapture.service.ZhihuService;

@Controller
public class ZhihuController {
	@Autowired
	ModelAndView mv;
	
	@Autowired
	ZhihuService zhihuService;
	
	@RequestMapping(value="zhihuInit",method=RequestMethod.GET)
	public ModelAndView getZhihuInit(HttpServletRequest request){
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));
		Map<String,Integer> limits = new HashMap<String,Integer>();
		limits.put("begin", begin);
		limits.put("end", end);
		List<ZhihuPojo> zhihuList = zhihuService.getCertainInfo(limits);
		if(zhihuList!=null)
			mv.addObject("zhihuList", zhihuList);
		mv.setViewName("zhihuMain");
		return mv;
	}
}
