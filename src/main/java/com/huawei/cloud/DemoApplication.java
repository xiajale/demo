package com.huawei.cloud;

import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication{

	public static void main(String[] args) {

		try {
			InitializationService.initialize();
		} catch (InitializationException e) {
			e.printStackTrace();
		}

		SpringApplication.run(DemoApplication.class, args);
	}
}
