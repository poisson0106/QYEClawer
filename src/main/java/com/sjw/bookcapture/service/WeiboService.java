package com.sjw.bookcapture.service;

import java.util.List;

import com.sjw.bookcapture.pojo.WeiboPojo;

public interface WeiboService {
	public List<WeiboPojo> getCertainWeiboService(int begin,int end);
}
