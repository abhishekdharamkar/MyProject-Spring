package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentDb")
public class Student {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	    private String Fname;
	    private String Lname;
//	    private String male;
//	    private String female;
	    private String City;
	    private String Roll_No;
	    private String Email;
	    private String Mobile;
	    
	    
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFname() {
			return Fname;
		}
		public void setFname(String fname) {
			Fname = fname;
		}
		public String getLname() {
			return Lname;
		}
		public void setLname(String lname) {
			Lname = lname;
		}
//		public String getMale() {
//			return male;
//		}
//		public void setMale(String male) {
//			this.male = male;
//		}
//		public String getFemale() {
//			return female;
//		}
//		public void setFemale(String female) {
//			this.female = female;
//		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getRoll_No() {
			return Roll_No;
		}
		public void setRoll_No(String roll_No) {
			Roll_No = roll_No;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getMobile() {
			return Mobile;
		}
		public void setMobile(String mobile) {
			Mobile = mobile;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", City=" + City + ", Roll_No=" + Roll_No + ", Email=" + Email + ", Mobile=" + Mobile
					+ "]";
		}
	    
	    
	    
}
