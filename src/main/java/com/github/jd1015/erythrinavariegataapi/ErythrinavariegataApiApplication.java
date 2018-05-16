package com.github.jd1015.erythrinavariegataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ErythrinavariegataApiApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ErythrinavariegataApiApplication.class, args);
	}

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("PUT", "GET", "DELETE","POST");
  }

}
