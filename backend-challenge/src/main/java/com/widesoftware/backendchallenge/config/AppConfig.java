package com.widesoftware.backendchallenge.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.widesoftware.backendchallenge")
@PropertySource(value= {"classpath:properties/application.properties", 
		"classpath:properties/spotify.properties",
		"../../../../../credentials/spotify.credentials.properties"})
public class AppConfig {

}