package com.sjw.bookcapture.dao;

import java.util.List;
import java.util.Map;

import com.sjw.bookcapture.pojo.UserPojo;

public interface AuthenticationDao {
	public UserPojo getUserByUsername(String username);
	public List<String> getserAuthorities(String username);
	public boolean registerOneUser(UserPojo thisUser);
	public boolean registerRole(Map<String,String> role);
}
