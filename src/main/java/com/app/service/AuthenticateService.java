package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.custom_exception.AuthenticationFailureException;

@Service
public class AuthenticateService implements IAuthenticationService {

	private RestTemplate restTemplate;
	
//	@Value("${user.authenticate.url}")
	private String authUrl;
	
	@Autowired
	public AuthenticateService(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	@Override
	public void checkAuthentication(String token) throws AuthenticationFailureException {
		System.out.println("in check auth entered");
		ResponseEntity<Boolean> respEntity = restTemplate.getForEntity(authUrl, Boolean.class, token);
		System.out.println("in check auth: rest service called");
		Boolean isAuthenticated = respEntity.getBody();
		
		if(!isAuthenticated.booleanValue()) {
			throw new AuthenticationFailureException("User authentication failed..!");
		}
		
	}

}
