package com.sjw.bookcapture.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sjw.bookcapture.pojo.UserPojo;

public interface AuthenticationService extends UserDetailsService {
	public Boolean registerOneUserService(UserPojo thisUser);

}
