package com.sjw.bookcapture.service;

import java.util.List;
import java.util.Map;

import com.sjw.bookcapture.pojo.ZhihuPojo;

public interface ZhihuService {
	public List<ZhihuPojo> getCertainInfo(Map<String,Integer> limits);
}
