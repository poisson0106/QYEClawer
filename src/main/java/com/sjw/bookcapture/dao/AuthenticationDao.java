package com.sjw.bookcapture.dao;

import java.util.List;

import com.sjw.bookcapture.pojo.UserPojo;

public interface AuthenticationDao {
	public UserPojo getUserByUsername(String username);
	public List<String> getserAuthorities(String username);
}
