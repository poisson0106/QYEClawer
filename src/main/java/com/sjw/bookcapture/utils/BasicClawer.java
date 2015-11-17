package com.sjw.bookcapture.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class BasicClawer {
	
	private HttpClient client;
	
	public HttpResponse getHttpContentGet(String url){
		List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();
		client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = client.execute(httpGet);  
            if (response != null) {
                return response;  
            }  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			//client.getConnectionManager().shutdown();
		}
		return null;
	}
	
	public void CloseClient(){
		client.getConnectionManager().shutdown();
	}
}
