package com.wipro.ProductInventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wipro.ProductInventory.model.UserEntity;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="products",path="products")
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByUserName(String userName);
	
	
	
}
