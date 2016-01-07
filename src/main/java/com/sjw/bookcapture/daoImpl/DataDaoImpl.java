package com.sjw.bookcapture.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.DataDao;
import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.pojo.ZhihuPojo;

public class DataDaoImpl extends SqlSessionDaoSupport implements DataDao {
	@Override
	public void catchZhihuDataDao(List<ZhihuPojo> thisList) throws Exception {
		this.getSqlSession().insert("insertNewZhihuData", thisList);
	}

	@Override
	public void catchWeiboDataDao(List<WeiboPojo> thisList) throws Exception {
		this.getSqlSession().insert("insertNewWeiboData",thisList);
		
	}

	@Override
	public void catchWeiboRefDataDao(List<WeiboPojo> refList) throws Exception {
		this.getSqlSession().insert("insertNewWeiboRefData",refList);
		
	}

}
