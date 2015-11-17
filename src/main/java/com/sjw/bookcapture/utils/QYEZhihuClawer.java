package com.sjw.bookcapture.utils;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class QYEZhihuClawer {
	private String url;
	
	public void catchAndUpdateZhihu() throws Exception{
		url="http://www.zhihu.com/people/autumnflutter";
		Connection conn = Jsoup.connect(url);
		Response response = conn.execute();
		Document doc = response.parse();
		Element el = doc.getElementById("zh-profile-activity-wrap");
		System.out.println(el.html());
	}
}
