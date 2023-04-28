package com.myTinyLibrary.main.config;

import java.util.*;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myTinyLibrary.main.interceptor.ConfirmInterceptor;

@Configuration
@MapperScan(basePackages = {"com.ssafy.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer {

private final List<String> patterns = Arrays.asList("/article/*", "/admin", "/user/list");
	
//	private ConfirmInterceptor confirmInterceptor;
	
	@Autowired
//	public WebMvcConfiguration(ConfirmInterceptor confirmInterceptor) {
//		super();
//		this.confirmInterceptor = confirmInterceptor;
//	}

	public WebMvcConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(confirmInterceptor).addPathPatterns(patterns);
//	}

	@Override
	// 프로젝트 전역에 CrossOrigin 설정
	public void addCorsMappings(CorsRegistry registry) {
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
}
