package com.sjw.bookcapture.serviceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:servlet-context.xml","classpath:spring-security.xml"})
@WebAppConfiguration
public class TestAuthenticationServiceImpl {
	@Autowired
    private WebApplicationContext context;
	
	@Autowired
	private AuthenticationServiceImpl authService;

    private MockMvc mvc;

    @Before
    public void setup() {
       /* mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();*/
    }
    
    @Test
    public void testLoadUserByUsername(){
    	
    }
}
