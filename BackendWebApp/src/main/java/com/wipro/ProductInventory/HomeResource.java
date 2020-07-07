package com.wipro.ProductInventory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.ProductInventory.dao.UserRepository;
import com.wipro.ProductInventory.model.UserEntity;

@RestController
public class HomeResource {
	
	@Autowired
	private UserRepository userRepo;
	
	private ModelAndView mv;
	
	@GetMapping("/products")
	public String home() {
		return ("<h1>Welcome</h1>");
	}
	
	@RequestMapping("/user")
	public String user() {
		/*mv= new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("userlogin");
		
		return mv;*/
		return "<h1>Welcome user<h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	/*@PutMapping("/register")
	public String registerUser(UserEntity user) {
		if(userRepo.findByUserName(userName)
				mv = new ModelAndView();
				mv.addObject(obj, user);
				return "<h1>Registered Succesfully..<h1>";
				
	
	}*/
	
}
