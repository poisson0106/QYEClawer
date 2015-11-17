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
		thisClawer.catchAndUpdateZhihu();
	}
}
