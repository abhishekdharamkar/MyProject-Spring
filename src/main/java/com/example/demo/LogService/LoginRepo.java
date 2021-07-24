package com.example.demo.LogService;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface LoginRepo extends JpaRepository<Login,Integer>{
	
	
	@Query("from Login l where l.userName=?1 and l.password=?2" )
	Optional<Login> checkLogin(String userName, String password);

}
