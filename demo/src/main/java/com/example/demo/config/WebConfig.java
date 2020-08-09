package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.config.aop.RoleIntercepter;
import com.example.demo.config.aop.SessionIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer {  // web.xml 처럼 작동한다

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new SessionIntercepter())
		.addPathPatterns("/user/**");
		
		registry.addInterceptor(new RoleIntercepter())
		.addPathPatterns("/admin/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
}
