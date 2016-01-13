package com.sjw.bookcapture.serviceImpl;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjw.bookcapture.dao.WeiboDao;
import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.service.WeiboService;

@Service
public class WeiboSeviceImpl implements WeiboService {
	@Autowired
	WeiboDao weiboDao;

	@Override
	public String getCertainWeiboService(Map<String,Integer> limits) throws JsonProcessingException {
		List<WeiboPojo> thisList = weiboDao.getCertainWeiboDao(limits);
		List<String> limit=thisList.stream()
				.filter(pojo->pojo.getRefWeibo()==1)
				.map(pojo->pojo.getUid())
				.collect(Collectors.toList());
		List<WeiboPojo> refList = weiboDao.getCertainWeiboRefDao(limit);
		Map<String,WeiboPojo> ref = refList.stream().collect(Collectors.toMap(WeiboPojo::getUid, pojo->pojo));
		Iterator<WeiboPojo> i = thisList.iterator();
		while(i.hasNext()){
			WeiboPojo w = i.next();
			if(w.getRefWeibo()==1)
				w.setRefWeiboDetail(ref.get(w.getUid()));
		}
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.writeValueAsString(thisList);
		
	}

}
