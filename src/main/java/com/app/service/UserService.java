package com.app.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.UserRepository;
import com.app.entity.User;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public User getUserDetails(long userId) {
		
		return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid userId...!, user doesn't exits...!"));
	}

}
