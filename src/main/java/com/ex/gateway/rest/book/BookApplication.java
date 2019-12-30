package com.ex.gateway.rest.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BookApplication {

	/*  
	 * Hitting this URL once started the gateway application running under  port:8686
	 * which is routing according to the zuul configuration given as  
	 * (zuul.routes.books-app.url=http://localhost:8090) 
	 * */
	
//	http://localhost:8686/books-app/available
  @RequestMapping(value = "/available")
  public String available() {
    return "Spring in Action";
  }

//  http://localhost:8686/books-app/checked-out
  @RequestMapping(value = "/checked-out")
  public String checkedOut() {
    return "Spring Boot (gateway routing) in Action";
  }

  public static void main(String[] args) {
    SpringApplication.run(BookApplication.class, args);
  }
}

//	Execute gateway application and hit the below URLs... 
//	http://localhost:8686/books-app/checked-out
//	http://localhost:8686/books-app/available
//	...request get routed to *book* application methods through port 8090, which was defined in zuul(books-app)...
//	(zuul.routes.books-app.url=http://localhost:8090 in gateway application)


