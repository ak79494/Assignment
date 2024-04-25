package com.arun.Demo2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean findByUserName(String username);
	
	

}
