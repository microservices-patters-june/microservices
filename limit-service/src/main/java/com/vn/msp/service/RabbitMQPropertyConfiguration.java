package com.vn.msp.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("limits-event.rabbitmq")
public class RabbitMQPropertyConfiguration {

	private String exchange;
    private String routingkey;
    private String queue;
    
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getRoutingkey() {
		return routingkey;
	}
	public void setRoutingkey(String routingkey) {
		this.routingkey = routingkey;
	}
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
}
