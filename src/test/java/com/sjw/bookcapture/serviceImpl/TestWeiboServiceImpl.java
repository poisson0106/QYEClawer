package com.sjw.bookcapture.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.service.WeiboService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:servlet-context.xml","classpath:spring-security.xml"})
public class TestWeiboServiceImpl {
	@Autowired
	WeiboService weiboService;
	
	@Test
	public void testGetCertainWeiboService() throws JsonProcessingException{
		Map<String,Integer> limits = new HashMap<String,Integer>();
		limits.put("begin", 0);
		limits.put("end", 5);
		weiboService.getCertainWeiboService(limits);
	}
}
