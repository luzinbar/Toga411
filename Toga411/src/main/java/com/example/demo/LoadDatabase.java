package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

/*
 * The following class will get loaded automatically by Spring. When it gets loaded:
 * - Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
 * - This runner will request a copy of the UserRepository you just created.
 * - Using it, it will create two entities and store them.
 */

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> { 
    };
  }
}