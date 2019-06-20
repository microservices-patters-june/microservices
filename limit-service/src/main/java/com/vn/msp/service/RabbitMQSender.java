package com.vn.msp.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vn.msp.model.LimitConfiguration;

@Service
public class RabbitMQSender {

	@Autowired
	@Qualifier("cuaTemplate")
	private AmqpTemplate rabbitTemplate;

	@Autowired
	private RabbitMQPropertyConfiguration configuration;

	public void send(LimitConfiguration limits) {
		rabbitTemplate.convertAndSend(configuration.getExchange(), configuration.getRoutingkey(), limits);
		System.out.println("Send msg = " + limits);

	}


}
