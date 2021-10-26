package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity is a JPA annotation to make this object ready for storage in a JPA-based data store
@Entity
public class User {
	
	private @Id @GeneratedValue Long id; // primary key
	private String phoneNumber;
	private String name;
	
	User() {}

	User(String phoneNumber, String name) {
		this.phoneNumber = phoneNumber;
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
