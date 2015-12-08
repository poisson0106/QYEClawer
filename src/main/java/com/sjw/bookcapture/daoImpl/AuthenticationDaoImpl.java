package com.sjw.bookcapture.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.AuthenticationDao;
import com.sjw.bookcapture.pojo.UserPojo;

public class AuthenticationDaoImpl extends SqlSessionDaoSupport implements AuthenticationDao {

	@Override
	public UserPojo getUserByUsername(String username) {
		return this.getSqlSession().selectOne("getUserByUsername",username);
	}

	@Override
	public List<String> getserAuthorities(String username) {
		return this.getSqlSession().selectList("getserAuthorities", username);
	}
	
}
