package com.wipro.ProductInventory;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wipro.ProductInventory.dao.UserRepository;
import com.wipro.ProductInventory.model.UserEntity;

@RestController
public class HomeResource {
	
	@Autowired
	private UserRepository userRepo;
	
	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:8282");
			}
		};
	}
	
	@GetMapping("/products")
	public List<UserEntity> productsList() {
		
		return userRepo.findAll();
	}
	@RequestMapping("/product/{userName}")
	public Optional<UserEntity> getproduct(@PathVariable("userName") String userName) {
		
		return userRepo.findByUserName(userName);
	}
	@PostMapping("/adduser")
	public UserEntity addUser(@RequestBody UserEntity user){
		System.out.println("hi");
		userRepo.save(user);
		return user;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		UserEntity user = userRepo.getOne(id);
		
		userRepo.delete(user);;
		return "deleted";
	}
	@PutMapping("/user/{id}")
	public UserEntity updateUser(@PathVariable("id") int id) {
		UserEntity user = userRepo.getOne(id);
		
		userRepo.save(user);
		return user;
	}
	
	
	
	/*@RequestMapping("/user")
	public String user() {
		mv= new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("userlogin");
		
		return mv;
		return "<h1>Welcome user<h1>";
	}*/
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	@RequestMapping("/addUser")
	public String registerUser(UserEntity user) {
		userRepo.save(user);
		return "home.jsp";		
	
	}
	
}
