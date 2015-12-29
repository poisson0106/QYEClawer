package com.sjw.bookcapture.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjw.bookcapture.dao.WeiboDao;
import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.service.WeiboService;

@Service
public class WeiboSeviceImpl implements WeiboService {
	@Autowired
	WeiboDao weiboDao;

	@Override
	public List<WeiboPojo> getCertainWeiboService(Map<String,Integer> limits) {
		return weiboDao.getCertainWeiboDao(limits);
	}

}
