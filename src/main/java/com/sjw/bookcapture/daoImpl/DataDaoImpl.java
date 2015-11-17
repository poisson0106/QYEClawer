package com.sjw.bookcapture.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.DataDao;
import com.sjw.bookcapture.pojo.WeiboPojo;

public class DataDaoImpl extends SqlSessionDaoSupport implements DataDao {

	@Override
	public void insertAllNewWeibo(List<WeiboPojo> toInsertList) throws Exception {
		this.getSqlSession().insert("insertAllNewWeibo", toInsertList);
	}

}
