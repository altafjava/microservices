package com.altafjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altafjava.bean.LimitConfiguration;
import com.altafjava.config.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration() {
		throw new RuntimeException("Lets say Some exception occured");
	}

	public LimitConfiguration fallbackRetrieveConfiguration() {
		return new LimitConfiguration(9999, 9);
	}
}
