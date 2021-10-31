package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



// @RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.

@RestController
class UserController {

	private final UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}
	
	  // GET ALL
	  @GetMapping("/users")
	  List<User> all() {
	    return repository.findAll();
	  }
	  
	  // POST – add another user and phone	
	  @PostMapping("/users")
	  User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }
	  
	  // GET – retrieve the user	  
	  @GetMapping("/users/{phoneNumber}") 
	  User one(@PathVariable String phoneNumber) {
	    
	    return repository.findByPhoneNumber(phoneNumber)
	      .orElseThrow(() -> new UserNotFoundException(phoneNumber));
	  }
	  
	  // PUT – update user name for phone number
	  @PutMapping("/users/{phoneNumber}") 
	  User replaceUser(@RequestBody User newUser, @PathVariable String phoneNumber) {
	    
	    return repository.findByPhoneNumber(phoneNumber)
	      .map(user -> {
	        user.setName(newUser.getName());
	        return repository.save(user);
	      })
	      .orElseGet(() -> {
	        newUser.setPhoneNumber(phoneNumber);
	        return repository.save(newUser);
	      });
	  }
	  
	  // DELETE – delete phone number
	  @DeleteMapping("/users/{phoneNumber}")
	  void deleteUser(@PathVariable String phoneNumber) {
		  if (phoneNumber == null) {
			  return;
		  }
	    //repository.deleteByPhoneNumber(phoneNumber);
		repository.delete(repository.findByPhoneNumber(phoneNumber).get());
	  }
}
