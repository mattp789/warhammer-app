package com.warhammer.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	Logger logger = LoggerFactory.getLogger(MvcConfig.class);

	public void addCorsMappings(CorsRegistry registry) {
		logger.debug("Adding CORS mappings");
		WebMvcConfigurer.super.addCorsMappings(registry);
		registry.addMapping("/*")
				.allowedOriginPatterns("http://localhost:[*]");
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/roll").setViewName("roll");
		registry.addViewController("/diceroller").setViewName("diceroller");
		registry.addViewController("/getunit").setViewName("getunit");
		registry.addViewController("/getarmy").setViewName("/getarmy");
	}

}
