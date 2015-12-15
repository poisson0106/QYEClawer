package com.sjw.bookcapture.dao;

import java.util.List;
import java.util.Map;

import com.sjw.bookcapture.pojo.ZhihuPojo;

public interface ZhihuDao {
	public List<ZhihuPojo> getCertainInfo(Map<String,Integer> limits);
}
