package com.yx.photo.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath*:/spring-*.xml")
public class PhotoLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoLoginApplication.class, args);
	}
}
