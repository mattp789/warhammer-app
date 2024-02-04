package com.warhammer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class WarhammerApp {

	public static void main(String[] args) {
		SpringApplication.run(WarhammerApp.class, args);
	}

}
