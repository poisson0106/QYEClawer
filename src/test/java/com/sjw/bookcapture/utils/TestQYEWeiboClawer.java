package com.sjw.bookcapture.utils;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjw.bookcapture.pojo.WeiboPojo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:servlet-context.xml"})
public class TestQYEWeiboClawer {
	@Autowired
	QYEWeiboClawer thisWeiboClawer;
	
	@Test
	public void testCatchAndUpdateWeibo() throws Exception{
		String url="http://www.weibo.com/langyabangdrama";
		List<WeiboPojo> testPojoList = thisWeiboClawer.catchAndUpdateWeibo(url);
		
		//Test for list 
		Iterator<WeiboPojo> i = testPojoList.iterator();
		while(i.hasNext()){
			WeiboPojo thisPojo = i.next();
			System.out.println("=====================================");
			System.out.println("Name is:");
			System.out.println(thisPojo.getName());
			System.out.println("Content is:");
			System.out.println(thisPojo.getInfo());
			System.out.println("The ref pics are:");
			System.out.println(thisPojo.getPicHref());
			System.out.println("The post date is:");
			System.out.println(thisPojo.getPostDate());
			System.out.println("The device is:");
			System.out.println(thisPojo.getPostBy());
			System.out.println("The related weibo level is:");
			System.out.println(thisPojo.getRefWeibo());
			System.out.println("The related uid is:");
			System.out.println(thisPojo.getUid());
			System.out.println("The fw num is:");
			System.out.println(thisPojo.getForwardNum());
			System.out.println("The comments num is:");
			System.out.println(thisPojo.getCommentsNum());
			System.out.println("The good num is:");
			System.out.println(thisPojo.getGoodNum());
			System.out.println("=====================================");
		}
	}
	
}
