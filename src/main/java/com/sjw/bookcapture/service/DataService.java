package com.sjw.bookcapture.service;

import java.util.List;

import com.sjw.bookcapture.pojo.ZhihuPojo;

public interface DataService {
	public void catchZhihuDataService(List<ZhihuPojo> thisList) throws Exception;
}
