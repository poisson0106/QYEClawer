package com.sjw.bookcapture.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class QYEWeiboClawer {
	public void catchAndUpdateWeibo() throws Exception{
		Connection conn = Jsoup.connect("http://www.weibo.com/p/1005052152564780");
	}
}
