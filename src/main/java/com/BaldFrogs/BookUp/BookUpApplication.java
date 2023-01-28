package com.BaldFrogs.BookUp;

import com.BaldFrogs.BookUp.Database.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BookUpApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BookUpApplication.class, args);
		Database.Init("src/main/resources/database.db");
	}
}
