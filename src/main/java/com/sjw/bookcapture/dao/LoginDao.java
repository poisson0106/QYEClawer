package com.sjw.bookcapture.dao;

import java.util.List;

import com.sjw.bookcapture.pojo.UserPojo;

public interface LoginDao {
	public UserPojo getUserByUsername(String username);
	public List<String> getserAuthorities(String username);
}
