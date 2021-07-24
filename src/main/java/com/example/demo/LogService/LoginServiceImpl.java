package com.example.demo.LogService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepo loginRepo;

	@Override
	public Optional<Login> checkLogin(String userName, String password) {
		return loginRepo.checkLogin(userName,password);
	}

}
