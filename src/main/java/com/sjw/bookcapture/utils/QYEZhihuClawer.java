package com.sjw.bookcapture.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.HasChildFilter;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;

public class QYEZhihuClawer extends BasicClawer{
	
	private String url;
	
	public void catchAndUpdateZhihu() throws Exception{
		
		//Test address
		url="http://www.zhihu.com/people/autumnflutter";
		
		HttpResponse response = this.getHttpContentGet(url);
		if(response!=null){
			HttpEntity entity = response.getEntity();
			Parser parser = new Parser(new Lexer(EntityUtils.toString(entity)));
			//HasAttributeFilter filter = new HasAttributeFilter("class","question_link");
			//NodeList list = parser.extractAllNodesThatMatch(filter);
			HasAttributeFilter filterTwo = new HasAttributeFilter("id","zh-profile-activity-wrap");
			HasChildFilter filterThree = new HasChildFilter(filterTwo);
			//AndFilter andFilter = new AndFilter(filter,filterTwo);
			NodeList list = parser.parse(filterThree);
			System.out.println("-------------------------------------");
			/*NodeIterator i = parser.elements();
			while(i.hasMoreNodes()){
				Node n = i.nextNode();
				if(n.toHtml().contains("zh-profile-activity-wrap")){
					System.out.println(n.toHtml());
				}
			}*/
			System.out.println(list.toHtml());
			System.out.println("-------------------------------------");
			this.CloseClient();
		}
	}
}
