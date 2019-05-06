package com.widesoftware.backendchallenge.spotifytestdouble.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.widesoftware.backendchallenge.spotifytestdouble")
@PropertySource(value="classpath:application.properties")
public class SpotifyTestdoubleApplicationConfig {}
