package com.altafjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.altafjava")
@EnableEurekaClient // @EnableEurekaClient lives in spring-cloud-netflix and only works for eureka.
					// If eureka is on your classpath, they are effectively the same.
//@EnableDiscoveryClient //There are multiple implementations of "Discovery Service" (eureka, consul, zookeeper). @EnableDiscoveryClient lives in spring-cloud-commons and picks the implementation on the classpath. 
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
