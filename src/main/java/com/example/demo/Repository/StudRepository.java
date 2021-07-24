package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Student;



public interface StudRepository extends JpaRepository<Student,Long> {
	@Query("SELECT p FROM Student p WHERE CONCAT(p.Fname, p.Lname, p.City, p.Roll_No) LIKE %?1%")
	public List<Student> search(String keyword);
//	 @Query("select u from Student u where u.Fname =: keyword" )
//	 public List <Student> getUserByName(String Fname);



}
