package com.sjw.bookcapture.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.service.DataService;

@Component
public class QYEWeiboClawer {
	@Autowired
	DataService dataService;
	
	private List<WeiboPojo> newWeibo;
	
	public List<WeiboPojo> catchAndUpdateWeibo(String url) throws Exception{
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
		String nickname = null;
		for(String b:a){
			if(b.contains("WB_cardwrap WB_feed_type S_bg2")){
				bd =b;
				break;
			}
			else if(b.contains("username")){
				nickname = b.substring(b.indexOf("\"username\">")+11,b.indexOf("</h1>"));
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
				this.analysisContent(thisEl,false,nickname);
			}
		}
		
		this.dataService.catchWeiboDataService(newWeibo);
		
		return newWeibo;
		
	}
	
	private String analysisContent(Element thisEl, Boolean isFw,String nickname){
		String uid = null;
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
			thisWeibo.setPicHref(hrefList);
		}
		
		//The the device and time information
		if(!thisEl.getElementsByClass("WB_from").isEmpty()){
			Elements fromAndTimeEls = null;
			Element fromEl = null;
			Element timeEl =null;
			
			if(!thisEl.getElementsByClass("WB_detail").isEmpty())
				fromAndTimeEls = thisEl.select(".WB_detail>.WB_from.S_txt2");
			else
				fromAndTimeEls = thisEl.select(".WB_from.S_txt2");
			
			//Time information
			timeEl = fromAndTimeEls.first().child(0);
			thisWeibo.setPostDate(timeEl.attr("title"));
			// From information
			fromEl = fromAndTimeEls.first().child(1);
			thisWeibo.setPostBy(fromEl.html());
		}
		
		//Get the good number,forward num and comment num
		if(!thisEl.getElementsByClass("WB_feed_handle").isEmpty()){
			Elements numEls = thisEl.select(".WB_row_line.WB_row_r4.clearfix.S_line2 .pos");
			this.getNumInformation(numEls, thisWeibo);
			
		}
		else if(!thisEl.getElementsByClass("WB_handle").isEmpty()){
			Elements numEls = thisEl.select(".WB_handle.W_fr .line.S_line1");
			this.getNumInformation(numEls, thisWeibo);
		}
		
		// Get the forward part information
		if(!thisEl.select(".WB_feed_expand").isEmpty()){
			Elements fwEls = thisEl.getElementsByClass("WB_feed_expand");
			Element fwEl = fwEls.first();
			if(!isFw){
				thisWeibo.setUid(this.analysisContent(fwEl,true,null));
				thisWeibo.setRefWeibo(WeiboType.FWCOMMENT.getNum());
				thisWeibo.setName(nickname);
			}
			else{
				uid = this.generateUID();
				String name = thisEl.child(1).child(0).child(0).attr("title");
				thisWeibo.setName(name);
				thisWeibo.setUid(uid);
				thisWeibo.setRefWeibo(WeiboType.FWCONTENT.getNum());
			}
		}
		else{
			thisWeibo.setName(nickname);
			thisWeibo.setRefWeibo(WeiboType.ORIGINAL.getNum());
		}
		
		newWeibo.add(thisWeibo);			
		return uid;
	}
	
	private String generateUID(){
		 String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
		 Random random = new Random();
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < 10; i++) {
			 int number = random.nextInt(base.length());
			 sb.append(base.charAt(number));
		 }
		 return sb.toString();
	}
	
	private void getNumInformation(Elements numEls,WeiboPojo thisWeibo){
		Iterator<Element> i = numEls.iterator();
		while(i.hasNext()){
			Element thisNum = i.next();
			if(thisNum.html().contains("转发") || thisNum.html().contains("评论")){
				String tmp = thisNum.child(0).html();
				int num=0;
				if(tmp.indexOf(" ")!=-1)
					num = Integer.parseInt(tmp.substring(tmp.indexOf(" "), tmp.length()).trim());
				
				if(tmp.contains("转发"))
					thisWeibo.setForwardNum(num);
				else if(tmp.contains("评论"))
					thisWeibo.setCommentsNum(num);
			}
			else if(thisNum.html().contains("<em>")){
				String tmp = thisNum.child(0).child(0).child(1).html();
				if(!tmp.isEmpty())
					thisWeibo.setGoodNum(Integer.parseInt(tmp));
				else
					thisWeibo.setGoodNum(0);
			}
		}
	}
}
