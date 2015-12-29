package com.sjw.bookcapture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.service.WeiboService;

@Controller
public class WeiboController {
	@Autowired
	WeiboService weiboService;
	
	@RequestMapping(value="getWeibo",method=RequestMethod.GET)
	@ResponseBody
	public String getCertainWeibo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));
		Map<String,Integer> limits = new HashMap<String,Integer>();
		limits.put("begin", begin);
		limits.put("end", end);
		List<WeiboPojo> weiboCol = weiboService.getCertainWeiboService(limits);
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.writeValueAsString(weiboCol);
	}
}
