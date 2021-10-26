package com.example.demo;

// an exception used to indicate when an employee is looked up but not found - HTTP 404

class UserNotFoundException extends RuntimeException {
	
	UserNotFoundException(String phoneNumber) {
	    super("Could not find user with phone number: " + phoneNumber);
	    }
	
}


