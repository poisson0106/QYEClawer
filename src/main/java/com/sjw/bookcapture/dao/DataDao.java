package com.sjw.bookcapture.dao;

import java.util.List;

import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.pojo.ZhihuPojo;

public interface DataDao {
	public void catchZhihuDataDao(List<ZhihuPojo> thisList) throws Exception;
	public void catchWeiboDataDao(List<WeiboPojo> thisList) throws Exception;
}
