package com.sjw.bookcapture.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sjw.bookcapture.dao.AuthenticationDao;
import com.sjw.bookcapture.pojo.UserPojo;
import com.sjw.bookcapture.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private AuthenticationDao authDao;
	
	@Autowired
	private UserCache userCache;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPojo thisUser=(UserPojo)this.userCache.getUserFromCache(username);
		if(thisUser ==null){
			thisUser = authDao.getUserByUsername(username);
			List<String> thisAuthorities = authDao.getserAuthorities(username);
			Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			Iterator<String> i = thisAuthorities.iterator();
			while(i.hasNext()){
				SimpleGrantedAuthority tmpAuth = new SimpleGrantedAuthority(i.next());
				authList.add(tmpAuth);
			}
			
			thisUser.setAuthorities(authList);
		}
		
		logger.info("------------------");
		logger.info("Username is:"+thisUser.getUsername());
		logger.info("Authorities:"+thisUser.getAuthorities());
		logger.info("------------------");
				
		this.userCache.putUserInCache(thisUser);
		
		return thisUser;
	}

	@Override
	public Boolean registerOneUserService(UserPojo thisUser) {
		if(authDao.registerOneUser(thisUser)){
			Map<String,String> role = new HashMap<String,String>();
			role.put("username", thisUser.getUsername());
			role.put("authorities", "ROLE_USER");
			authDao.registerRole(role);
			return true;
		}
		else
			return false;
	}

}
