package com.sjw.bookcapture.service;

import java.util.List;
import java.util.Map;

import com.sjw.bookcapture.pojo.WeiboPojo;

public interface WeiboService {
	public List<WeiboPojo> getCertainWeiboService(Map<String,Integer> limits);
}
