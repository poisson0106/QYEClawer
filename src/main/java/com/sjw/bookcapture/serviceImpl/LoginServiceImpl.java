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

import com.sjw.bookcapture.dao.LoginDao;
import com.sjw.bookcapture.pojo.UserPojo;
import com.sjw.bookcapture.service.LoginService;

public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDao loginDao;
	
	 @Autowired  
	UserCache userCache; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPojo thisUser=(UserPojo)this.userCache.getUserFromCache(username);
		if(thisUser ==null){
			thisUser = loginDao.getUserByUsername(username);
			List<String> thisAuthorities = loginDao.getserAuthorities(username);
			Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			Iterator<String> i = thisAuthorities.iterator();
			while(i.hasNext()){
				SimpleGrantedAuthority tmpAuth = new SimpleGrantedAuthority(i.next());
				authList.add(tmpAuth);
			}
			
			thisUser.setAuthorities(authList);
		}
		System.out.println("-----------------");
		System.out.println("Username is:"+thisUser.getUsername());
		System.out.println("-----------------");
		
		this.userCache.putUserInCache(thisUser);
		
		return thisUser;
	}

}
