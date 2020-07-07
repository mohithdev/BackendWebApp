package com.wipro.ProductInventory;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.ProductInventory.dao.UserRepository;
import com.wipro.ProductInventory.model.MyUserDetails;
import com.wipro.ProductInventory.model.UserEntity;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<UserEntity> user = userRepo.findByUserName(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException(username+ " Not found. Please enter correct details.."));
		
		return user.map(MyUserDetails::new).get();
		
	}
}