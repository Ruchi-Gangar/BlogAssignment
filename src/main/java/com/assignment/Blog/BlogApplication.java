package com.assignment.Blog;

import com.assignment.Blog.service.AdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BlogApplication {

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public AdminService getAdminService(){
		return new AdminService();
	}
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
