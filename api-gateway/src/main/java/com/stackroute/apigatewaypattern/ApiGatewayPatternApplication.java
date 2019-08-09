package com.stackroute.apigatewaypattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//Annotation for enabling proxy for the services
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayPatternApplication.class, args);
	}

}
