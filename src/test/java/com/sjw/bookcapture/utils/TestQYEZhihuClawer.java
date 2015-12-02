package com.sjw.bookcapture.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:servlet-context.xml"})
public class TestQYEZhihuClawer extends AbstractJUnit4SpringContextTests{
	@Autowired
	QYEZhihuClawer thisClawer;
	
	/*@Before
	public void setUp(){
		thisClawer = new QYEZhihuClawer();
	}*/
	
	@Test
	public void testCatchAndUpdateZhihu() throws Exception{
		String url="http://www.zhihu.com/people/autumnflutter";
		thisClawer.catchAndUpdateZhihu(url);
	}
}
