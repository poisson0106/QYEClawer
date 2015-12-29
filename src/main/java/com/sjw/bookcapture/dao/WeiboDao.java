package com.sjw.bookcapture.dao;

import java.util.List;
import java.util.Map;

import com.sjw.bookcapture.pojo.WeiboPojo;

public interface WeiboDao {
	public List<WeiboPojo> getCertainWeiboDao(Map<String,Integer> limits);
}
