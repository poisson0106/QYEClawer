package com.sjw.bookcapture.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.sjw.bookcapture.pojo.WeiboPojo;

public class QYEWeiboClawer {
	
	private List<WeiboPojo> newWeibo;
	
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
		String tmp = doc.html().replaceAll("\\\\t", "").replaceAll("\\\\n", "").replaceAll("\\\\r", "").replaceAll("\\\\", "").replaceAll("  ", "");
		String[] a = tmp.split("<script>FM.view");
		String bd = null;
		for(String b:a){
			if(b.contains("WB_cardwrap WB_feed_type S_bg2")){
				bd =b;
				break;
			}
		}
		if(bd!=null){
			String end = "\"})</script>";
			bd = bd.trim().substring(bd.indexOf("<div"), bd.indexOf(end));
			Document ndoc = Jsoup.parse(bd);
			Elements els = ndoc.select(".WB_cardwrap.WB_feed_type.S_bg2");
			newWeibo = new ArrayList<WeiboPojo>();
			Iterator<Element> i = els.iterator();
			while(i.hasNext()){
				Element thisEl = i.next();
				this.analysisContent(thisEl,false);
			}
		}
		/*Elements els = ndoc.select(".WB_cardwrap");
		Iterator<Element> i = els.iterator();
		while(i.hasNext()){
			System.out.println(i.next().html());
		}*/
	}
	
	public int analysisContent(Element thisEl, Boolean isFw){
		int index=0;
		WeiboPojo thisWeibo = new WeiboPojo();
		
		//Get Main Content
		if(!thisEl.getElementsByClass("W_f14").isEmpty()){
			Elements mainContent = thisEl.select(".WB_text.W_f14");
			if(thisEl.getElementsByClass("W_icon_feedhot") != null)
				thisEl.getElementsByClass("W_icon_feedhot").remove();
			thisWeibo.setInfo(mainContent.html());
		}
		else if(!thisEl.getElementsByClass("WB_text").isEmpty()){
			Elements mainContent = thisEl.getElementsByClass("WB_text");
			//System.out.println(mainContent.html());
			thisWeibo.setInfo(mainContent.html());
		}
		
		//Get the media information under this weibo(without forward)
		if((!thisEl.getElementsByClass("WB_media_wrap").isEmpty() && thisEl.getElementsByClass("WB_feed_expand").isEmpty())||
		   (!thisEl.getElementsByClass("WB_feed_expand").isEmpty() && isFw && !thisEl.getElementsByClass("WB_media_wrap").isEmpty())){
			Elements picContent = null;
			if(isFw)
				picContent = thisEl.select(".WB_pic.S_bg2");
			else
				picContent = thisEl.select(".WB_pic.S_bg1");
			Iterator<Element> pics = picContent.iterator();
			String hrefList=null;
			while(pics.hasNext()){
				Element pic = pics.next();
				if(hrefList == null)
					hrefList = pic.childNode(0).attr("src");
				else
					hrefList = hrefList+","+pic.childNode(0).attr("src");
			}
			System.out.println(hrefList);
			thisWeibo.setPicHref(hrefList);
		}
		
		if(!thisEl.select(".WB_feed_expand").isEmpty()){
			Elements fwEls = thisEl.getElementsByClass("WB_feed_expand");
			Element fwEl = fwEls.first();
			if(!isFw)
				index = this.analysisContent(fwEl,true);
		}
		
		thisWeibo.setRefWeibo(index);
		
		newWeibo.add(thisWeibo);
							
		return index;
	}
}
