package com.widesoftware.backendchallenge.openweathermaptestdouble.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.widesoftware.backendchallenge.openweathermap.testdouble")
@PropertySource(value="classpath:application.properties")
public class OpenweathermapTestdoubleApplicationConfig {

}
