package com.app.service;

import com.app.custom_exception.AuthenticationFailureException;

public interface IAuthenticationService {

	void checkAuthentication(String token) throws AuthenticationFailureException;

}
