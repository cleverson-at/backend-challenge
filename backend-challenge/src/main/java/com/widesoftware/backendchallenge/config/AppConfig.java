package com.widesoftware.backendchallenge.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.widesoftware.backendchallenge")
@PropertySource(value= {"classpath:properties/application.properties", 
		"classpath:properties/spotify.properties",
		"classpath:properties/openweathermap.properties",
		"file:${CREDENTIALS_PATH}/spotify.credentials.properties",
		"file:${CREDENTIALS_PATH}/openweathermap.credentials.properties"})
public class AppConfig {

}
