package com.sjw.bookcapture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjw.bookcapture.pojo.UserPojo;
import com.sjw.bookcapture.service.AuthenticationService;

@Controller
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	ModelAndView mv;
	
	@RequestMapping(value="loginInit",method=RequestMethod.GET)
	public ModelAndView initialOneUser() throws Exception{
		/*ModelAndView mv = new ModelAndView();*/
		mv.setViewName("Login");
		return mv;
	}
	
	@RequestMapping(value="loginRedirect",method=RequestMethod.GET)
	public ModelAndView loginRedirect() throws Exception{
		/*ModelAndView mv = new ModelAndView();*/
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="registerInit",method=RequestMethod.GET)
	public ModelAndView initalRegister() throws Exception{
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value="authFailed",method=RequestMethod.GET)
	public ModelAndView authFailed(){
		mv.setViewName("errorpage");
		return mv;
	}
	
	@RequestMapping(value="loginOneUser",method=RequestMethod.POST)
	public ModelAndView loginOneUser(HttpServletRequest request) throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = authManager.authenticate(authRequest); //调用loadUserByUsername
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
	    mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="registerOneUser",method=RequestMethod.POST)
	public ModelAndView registerOneUser(HttpServletRequest request) throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		password = md5.encodePassword(password, username);
		UserPojo thisUser = new UserPojo(username,password);
		authenticationService.registerOneUserService(thisUser);
		mv.setViewName("Login");
		return mv;
	}
	
}
