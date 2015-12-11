package com.sjw.bookcapture.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:servlet-context.xml","classpath:spring-security.xml"})
public class TestAuthenticationController {
	@Autowired
	AuthenticationController loginController;
	
	@Test
	@WithMockUser
	public void testLoginOneUser() throws Exception{
		loginController.loginRedirect();
	}
}
