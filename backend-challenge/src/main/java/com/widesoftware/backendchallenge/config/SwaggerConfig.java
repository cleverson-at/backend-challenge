package com.widesoftware.backendchallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.widesoftware.backendchallenge.gateways.rest.SuggestedSongs;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ComponentScan(basePackageClasses = SuggestedSongs.class)
@PropertySource("classpath:properties/swagger.properties")
public class SwaggerConfig {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String TITLE = "Backend Challenge API";
    private static final String DESCRIPTION = "RESTful API for the Backend Challenge API";
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket productsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }
	
}
