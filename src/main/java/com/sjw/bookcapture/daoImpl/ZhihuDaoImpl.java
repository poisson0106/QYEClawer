package com.sjw.bookcapture.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.ZhihuDao;
import com.sjw.bookcapture.pojo.ZhihuPojo;

public class ZhihuDaoImpl extends SqlSessionDaoSupport implements ZhihuDao {

	@Override
	public List<ZhihuPojo> getCertainInfo(Map<String,Integer> limits) {
		return this.getSqlSession().selectList("getCertainInfo",limits);
	}

}
