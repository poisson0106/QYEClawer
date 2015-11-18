package com.sjw.bookcapture.utils;

import org.junit.Before;
import org.junit.Test;

public class TestQYEZhihuClawer {
	QYEZhihuClawer thisClawer;
	
	@Before
	public void setUp(){
		thisClawer = new QYEZhihuClawer();
	}
	
	
	@Test
	public void testCatchAndUpdateZhihu() throws Exception{
		String url="http://www.zhihu.com/people/autumnflutter";
		thisClawer.catchAndUpdateZhihu(url);
	}
}
