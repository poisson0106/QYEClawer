package com.sjw.bookcapture.dao;

import java.util.List;

import com.sjw.bookcapture.pojo.WeiboPojo;

public interface DataDao {
	public void insertAllNewWeibo(List<WeiboPojo> toInsertList) throws Exception;
}
