package com.vn.msp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.vn.msp.model.LimitConfiguration;

@Service
public class Receiver {

	@RabbitListener(queues="${limits-event.rabbitmq.queue}")
	public void receiveMessage(LimitConfiguration message) {
    	System.out.println("Received <" + message + ">");
	}

}
