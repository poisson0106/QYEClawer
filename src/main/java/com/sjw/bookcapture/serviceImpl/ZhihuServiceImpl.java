package com.sjw.bookcapture.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjw.bookcapture.dao.ZhihuDao;
import com.sjw.bookcapture.pojo.ZhihuPojo;
import com.sjw.bookcapture.service.ZhihuService;

@Service
public class ZhihuServiceImpl implements ZhihuService {
	@Autowired
	ZhihuDao zhihuDao;

	@Override
	public List<ZhihuPojo> getCertainInfo(Map<String,Integer> limits) {
		return zhihuDao.getCertainInfo(limits);
	}

}
