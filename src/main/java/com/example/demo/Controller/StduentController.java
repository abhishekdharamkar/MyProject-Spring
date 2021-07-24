package com.example.demo.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Student;

import com.example.demo.Service.StudentService;
import com.example.demo.Service.StudentServiceImpl;



import com.example.demo.LogService.*;

@Controller
public class StduentController {


	@Autowired
    private StudentService service;
//	@Autowired
//	private StudRepository repo;
	@Autowired
	private StudentServiceImpl sms;

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
    public String viewHomePage(Model model) 
    {
		return "Loginform";	
	}
	@PostMapping(value="/checkLogin")
	@ResponseBody
	public  ResponseEntity<Object> checkLogin( Login login) {
		try {
	Optional<Login>optional=loginService.checkLogin(login.getUserName(),login.getPassword());
		

		if(optional.isPresent()) {
			System.out.println("PASSWORD IS Correct");
			 return ResponseEntity.status(HttpStatus.FOUND)
				        .location(URI.create("http://localhost:8081/add"))
				        .build();
					
		}
		else {
			return ResponseEntity.status(HttpStatus.FOUND)
			        .location(URI.create("http://localhost:8081/inc"))
			        .build();
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return null;
	}
	
	 @RequestMapping(value="/add")
	 public String add() {
		return "ADDSTUDENT";
	 }
		
	 @RequestMapping(value="/inc")
		 public String add1() {
			return "inc";
		
	}
	
	@RequestMapping("/Abhi")
	public String abc() {
		return "index";
	}

	

	
    @RequestMapping("/show")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Student> liststudent = service.listAll(keyword);
        model.addAttribute("liststudent", liststudent);
        model.addAttribute("keyword", keyword);
         
        return "index";
    }
    
    @RequestMapping("/new")
    public String showNewProductForm(Model model) {
    	Student student = new Student();
    	model.addAttribute("student", student);
    	return "add";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savestudent(@ModelAttribute("student") Student student,String Fname )
    {
    	service.save(student);
    	
    	
    	//StringBuilder sb=new StringBuilder();  
    	String s=student.toString();  
    	System.out.println(s);
    	sms.SMS(Fname);
//    	//////////////
   	
//    	String ACCOUNT_SID =
//	            "AC2de808e86e04d8c0309dff859388cd03";
//	  String AUTH_TOKEN =
//	            "c61ce2ddd8eb1b380a14f3925b093b82";
//	  	String msg="New Entry - NAME : "+name;
//	  	
//   
//	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//	        Message message = Message
//	                .creator(new PhoneNumber("+919096904640"), // to
//	                        new PhoneNumber("+17275131648"), // from
//	                        msg)
//	                .create();
	        
	        
	        //////////
    	 return "redirect:/show";
    	 
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") Long id) {
    ModelAndView mav= new ModelAndView("edit");
    
    Student student = service.get(id);
    mav.addObject("student",student);
    return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/show";       
    }
 
    
  
}
