package com.tranvuhoang.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;

import io.swagger.models.auth.In;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@PropertySource("classpath:swagger.properties")
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Value("${springfox.documentation.swagger.v2.path}")
	private String swagger2Endpoint;
	
    @Bean
    public Docket api() {
    	return new Docket(DocumentationType.SWAGGER_2)
			.securitySchemes(Arrays.asList(new ApiKey(
				"Bearer Token", 
				HttpHeaders.AUTHORIZATION, 
				In.HEADER.name())
			))
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();    
    }

}