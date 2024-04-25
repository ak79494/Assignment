package com.arun.Demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {
  @Autowired
  private UserRepository userRepository;
  
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
	  if(userRepository.findByUserName(signupRequest.getUsername())) {
		  return ResponseEntity.badRequest().body("Username is already taken");
		  
	  }
	  User user = new User();
	  user.setUsername(signupRequest.getUsername());
	  user.setPassword(signupRequest.getPassword());
	  userRepository.save(user);
	  return ResponseEntity.ok("User registered Successfully");
  }
}
