package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudRepository;



@Service
public class StudentService {
	@Autowired
	StudRepository Repo;
	
	public List<Student> listAll(){
		return Repo.findAll();
	}
	
	public void save(Student student) {
		Repo.save(student);
	}
	 public Student get(Long id) {
		 return Repo.findById(id).get();
	 }
	
	 public void delete(Long id) {
		 Repo.deleteById(id);
	 }
	 ///////////
	  public List<Student> listAll(String keyword) {
	        if (keyword != null) {
	            return Repo.search(keyword);
	        }
	        return Repo.findAll();
	    }
//	  public List<Student> get(String key){
//		return Repo.getUserByName(key);
//		  
//	  }
}
