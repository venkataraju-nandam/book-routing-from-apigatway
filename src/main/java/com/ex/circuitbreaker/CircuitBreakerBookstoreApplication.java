package com.ex.circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * This application is having 2 MAIN classes for testing purpose. 
 * One of them should be commented fully as no 2 main method classes should be allowed in a single application.
 * When running this, commenting the BookApplication.java class
 */

/*
 *  http://localhost:8091/to-read
 *  This get automatic routing from circuit-breaker microservice/CircuitBreakerReadingApplication running at port 8091, 
 *  and can test at  url:  http://localhost:8090/recommended
 *  And as soon as we stop the book microservice CircuitBreakerBookstoreApplication.java, 
 *  this routes to the default fallbackMethod = "reliable", and returns response from there.
 *   Once CircuitBreakerBookstoreApplication up and running again, circuit-breaker microservice 
 *   returns the response from book application.
 */

@RestController
@SpringBootApplication
public class CircuitBreakerBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerBookstoreApplication.class, args);
	}
	
	  @RequestMapping(value = "/recommended")
	  public String readingList(){
	  return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	  }

}
//http://localhost:8090/recommended


