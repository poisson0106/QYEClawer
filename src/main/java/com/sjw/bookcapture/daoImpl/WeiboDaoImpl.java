package com.sjw.bookcapture.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.WeiboDao;
import com.sjw.bookcapture.pojo.WeiboPojo;

public class WeiboDaoImpl extends SqlSessionDaoSupport implements WeiboDao {

	@Override
	public List<WeiboPojo> getCertainWeiboDao(Map<String,Integer> limits) {
		return this.getSqlSession().selectList("getCertainWeibo", limits);
	}

}
