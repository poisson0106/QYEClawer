package com.sjw.bookcapture.serviceImpl;

import java.util.List;

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
	public List<WeiboPojo> getCertainWeiboService(int begin, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
