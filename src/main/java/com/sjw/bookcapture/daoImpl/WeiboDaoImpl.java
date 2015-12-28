package com.sjw.bookcapture.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.WeiboDao;
import com.sjw.bookcapture.pojo.WeiboPojo;

public class WeiboDaoImpl extends SqlSessionDaoSupport implements WeiboDao {

	@Override
	public List<WeiboPojo> getCertainWeiboDao(int begin, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
