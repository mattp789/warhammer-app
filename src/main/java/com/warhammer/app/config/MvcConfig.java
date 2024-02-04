package com.warhammer.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/roll").setViewName("roll");
		registry.addViewController("/diceroller").setViewName("diceroller");
		registry.addViewController("/getunit").setViewName("getunit");
		registry.addViewController("/getalliances").setViewName("/getalliances");
	}

}