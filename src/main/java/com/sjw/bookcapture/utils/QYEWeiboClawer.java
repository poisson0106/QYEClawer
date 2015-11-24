package com.sjw.bookcapture.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QYEWeiboClawer {
	public void catchAndUpdateWeibo(String url) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("Apache", "3471694940278.2993.1448354185283");
		map.put("SINAGLOBAL", "6702268402505.439.1448353421592");
		map.put("SUB", "_2AkMhbACDf8NhqwJRmPoTymnlbYRwzQ7EiebDAHzsJxJTHm4u7M8wcOHmKE4EfS4tzNF9Cwn3U8Jo");
		map.put("SUBP", "0033WrSXqPxfM72-Ws9jqgMF55529P9D9WhwCWVJKfWRf2Ua-kbGFjB4");
		map.put("ULV", "1448354185285:3:3:3:3471694940278.2993.1448354185283:1448354061104");
		map.put("YF-Page-G0", "59104684d5296c124160a1b451efa4ac");
		map.put("_s_tentry", "-");
		Connection conn = Jsoup.connect(url);
		Response response = conn.cookies(map).method(Method.GET).execute();
		Document doc = response.parse();
		System.out.println(doc.body().html());
	/*	Elements els = doc.select(".WB_cardwrap");
		Iterator<Element> i = els.iterator();
		while(i.hasNext()){
			System.out.println(i.next().html());
		}*/
	}
}
