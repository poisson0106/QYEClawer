package com.sjw.bookcapture.dao;

import java.util.List;

import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.pojo.ZhihuPojo;

public interface DataDao {
	public void insertAllNewWeibo(List<WeiboPojo> toInsertList) throws Exception;
	public void catchZhihuDataDao(List<ZhihuPojo> thisList) throws Exception;
}
