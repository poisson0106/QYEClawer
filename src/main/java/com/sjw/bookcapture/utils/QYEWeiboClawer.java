package com.sjw.bookcapture.utils;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class QYEWeiboClawer {
	public void catchAndUpdateWeibo(String url) throws Exception{
		Connection conn = Jsoup.connect(url);
		Response response = conn.execute();
		Document doc = response.parse();
		System.out.println(doc.html());
	}
}
