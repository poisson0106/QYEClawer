package com.sjw.bookcapture.utils;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.sjw.bookcapture.pojo.ZhihuPojo;
import com.sjw.bookcapture.service.DataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml", "/spring-security.xml"})
public class QYEZhihuClawer {
	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	DataService dataService;
	
	
	public void catchAndUpdateZhihu(String url) throws Exception{
		Connection conn = Jsoup.connect(url);
		Response response = conn.execute();
		Document doc = response.parse();
		Elements els = doc.select("#zh-profile-activity-wrap .zm-item.clearfix");
		String prefix = "http://www.zhihu.com";
		List<ZhihuPojo> newActivities = new ArrayList<ZhihuPojo>();
		for(Element el:els){
			//System.out.println(el.html());
			if(el.select(".zm-profile-section-main .zg-link").html()==null)
				continue;
			else{
				ZhihuPojo thisPojo = new ZhihuPojo();
				thisPojo.setName(el.select(".zm-profile-section-main .zg-link").html());
				thisPojo.setQtime(el.select(".zm-profile-setion-time").html());
				
				String tmpContent = el.select(".zm-profile-section-main").html();
				if(tmpContent.contains("��ͬ�˻ش�"))
					thisPojo.setQtype("��ͬ�˻ش�");
				else if(tmpContent.contains("��ע������")){
					thisPojo.setQtype("��ע������");
					thisPojo.setQtitle(el.select(".question_link").html());
					thisPojo.setQhref(prefix+el.select(".question_link").attr("href"));
					newActivities.add(thisPojo);
					continue;
				}
				else if(tmpContent.contains("�ش�"))
					thisPojo.setQtype("�ش�������");
				else if(tmpContent.contains("��ͬ������"))
					thisPojo.setQtype("��ͬ������");
				else if(tmpContent.contains("��ע��ר��")){
					thisPojo.setQtype("��ע��ר��");
					thisPojo.setQtitle(el.select(".column_link").html());
					thisPojo.setQhref(el.select(".column_link").attr("href"));
					newActivities.add(thisPojo);
					continue;
				}
				
				thisPojo.setQtitle(el.select(".question_link").html());
				thisPojo.setQhref(prefix+el.select(".question_link").attr("href"));
				thisPojo.setAcontent(el.select(".zh-summary").html());
				newActivities.add(thisPojo);
			}
		}
		
		this.dataService.catchZhihuDataService(newActivities);
		
		/*Iterator<ZhihuPojo> i = newActivities.iterator();
		while(i.hasNext()){
			System.out.println(i.next().toString());
			System.out.println(" ");
		}*/
	}
}
