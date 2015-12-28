package com.sjw.bookcapture.dao;

import java.util.List;

import com.sjw.bookcapture.pojo.WeiboPojo;

public interface WeiboDao {
	public List<WeiboPojo> getCertainWeiboDao(int begin,int end);
}
