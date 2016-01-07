package com.sjw.bookcapture.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjw.bookcapture.pojo.WeiboPojo;

public interface WeiboService {
	public String getCertainWeiboService(Map<String,Integer> limits) throws JsonProcessingException;
}
