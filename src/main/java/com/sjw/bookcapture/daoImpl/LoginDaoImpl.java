package com.sjw.bookcapture.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.LoginDao;
import com.sjw.bookcapture.pojo.UserPojo;

public class LoginDaoImpl extends SqlSessionDaoSupport implements LoginDao {

	@Override
	public UserPojo getUserByUsername(String username) {
		return this.getSqlSession().selectOne("getUserByUsername",username);
	}

	@Override
	public List<String> getserAuthorities(String username) {
		return this.getSqlSession().selectList("getserAuthorities", username);
	}
	
}
