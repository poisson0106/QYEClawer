package com.sjw.bookcapture.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjw.bookcapture.dao.DataDao;
import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.pojo.ZhihuPojo;
import com.sjw.bookcapture.service.DataService;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	DataDao dataDao;
	
	public void catchZhihuDataService(List<ZhihuPojo> thisList) throws Exception{
		this.dataDao.catchZhihuDataDao(thisList);
	}

	@Override
	public void catchWeiboDataService(List<WeiboPojo> thisList,List<WeiboPojo> refList) throws Exception {
		this.dataDao.catchWeiboDataDao(thisList);
		this.dataDao.catchWeiboRefDataDao(refList);
	}
}
