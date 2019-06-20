package com.vn.msp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vn.msp.service.RabbitMQPropertyConfiguration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue queue(RabbitMQPropertyConfiguration config) {
		return new Queue(config.getQueue(), false);
	}

	@Bean
	public DirectExchange exchange(RabbitMQPropertyConfiguration config) {
		return new DirectExchange(config.getExchange());
	}

	@Bean
	public Binding binding(Queue queue, DirectExchange exchange, RabbitMQPropertyConfiguration config) {
		return BindingBuilder.bind(queue).to(exchange).with(config.getRoutingkey());
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	@Qualifier("cuaTemplate")
	public AmqpTemplate cuaTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}



}
