package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/*
By using UserRepository interface we can automatically do:
- POST – add another user and phone
- PUT – update user name for phone number
- DELETE – delete phone number
- GET – retrieve the user
 */

interface UserRepository extends JpaRepository <User, String> {
	
	/**
	 * Retrieves an entity by its phoneNumber.
	 *
	 * @param phoneNumber must not be {@literal null}.
	 * @return the entity with the given phoneNumber or {@literal Optional#empty()} if none found.
	 * @throws IllegalArgumentException if {@literal phoneNumber} is {@literal null}.
	 */
	Optional<User> findByPhoneNumber(String phoneNumber);
	
	/**
	 * Deletes the entity with the given phoneNumber.
	 *
	 * @param phoneNumber must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@literal phoneNumber} is {@literal null}
	 */
	void deleteByPhoneNumber(String phoneNumber);
	
}
