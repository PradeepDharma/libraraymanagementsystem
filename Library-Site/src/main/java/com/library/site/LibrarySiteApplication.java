package com.library.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.library.site")
public class LibrarySiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySiteApplication.class, args);
	}

}
