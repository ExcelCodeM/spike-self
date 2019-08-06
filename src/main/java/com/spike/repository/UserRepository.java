package com.spike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spike.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUsername(String username);

}
