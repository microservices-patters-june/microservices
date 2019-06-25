package com.vn.msp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vn.msp.model.LimitConfiguration;
import com.vn.msp.service.Configuration;
import com.vn.msp.service.RabbitMQSender;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@Autowired
    private RabbitMQSender sender;

	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		LimitConfiguration limits =  new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
		
		//sender.send(limits);
		
		return limits;		
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}
	
	public LimitConfiguration fallbackRetrieveConfiguration() {
		return new LimitConfiguration(999,9);
	}
	
	
}
