package com.example.demo.LogService;

import java.util.Optional;



public interface LoginService {
	
	public Optional<Login> checkLogin(String userName,String password);

}
