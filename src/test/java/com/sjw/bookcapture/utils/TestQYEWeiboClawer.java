package com.sjw.bookcapture.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:servlet-context.xml"})
public class TestQYEWeiboClawer {
	@Autowired
	QYEWeiboClawer thisWeiboClawer;
	
	@Test
	public void testCatchAndUpdateWeibo() throws Exception{
		String url="http://www.weibo.com/p/1005052152564780";
		thisWeiboClawer.catchAndUpdateWeibo(url);
	}
	
}
