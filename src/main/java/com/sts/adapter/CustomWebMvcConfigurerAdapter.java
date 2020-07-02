package com.sts.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CustomWebMvcConfigurerAdapter implements WebMvcConfigurer {
	public static final String STATIC_URL="/static";
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(STATIC_URL+"/**")
			.addResourceLocations("classpath:/static/");
	}
}
