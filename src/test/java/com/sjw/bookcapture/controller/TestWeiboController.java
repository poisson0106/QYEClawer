package com.sjw.bookcapture.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:servlet-context.xml","classpath:spring-security.xml"})
public class TestWeiboController {
	@Autowired
	WeiboController weiboController;
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private Logger logger;
	
	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		request.setParameter("begin", "0");
		request.setParameter("end", "5");
		logger= LoggerFactory.getLogger(this.getClass());
	}
	
	@Test
	public void testGetCertainWeibo(){
		try{
		logger.info(weiboController.getCertainWeibo(request, response));
		
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
