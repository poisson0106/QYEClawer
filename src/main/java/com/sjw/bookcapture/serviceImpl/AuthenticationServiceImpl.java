package com.sjw.bookcapture.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
	
	private AuthenticationDao authDao;
	
	/*private UserCache userCache;*/

	public AuthenticationDao getAuthDao() {
		return authDao;
	}

	public void setAuthDao(AuthenticationDao authDao) {
		this.authDao = authDao;
	}

	/*public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/*		UserPojo thisUser=(UserPojo)this.userCache.getUserFromCache(username);
		if(thisUser ==null){*/
			UserPojo thisUser = authDao.getUserByUsername(username);
			List<String> thisAuthorities = authDao.getserAuthorities(username);
			Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			Iterator<String> i = thisAuthorities.iterator();
			while(i.hasNext()){
				SimpleGrantedAuthority tmpAuth = new SimpleGrantedAuthority(i.next());
				authList.add(tmpAuth);
			}
			
			thisUser.setAuthorities(authList);
/*		}*/
		System.out.println("-----------------");
		System.out.println("Username is:"+thisUser.getUsername());
		System.out.println("Authorities:"+thisUser.getAuthorities());
		System.out.println("-----------------");
		
		/*this.userCache.putUserInCache(thisUser);*/
		
		return thisUser;
	}

}
