package com.wipro.ProductInventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ProductInventory.model.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByUserName(String userName);
	
	
}
