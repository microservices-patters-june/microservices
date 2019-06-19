package com.vn.msp;

import org.springframework.core.io.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

//	@Bean
//	public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
//
//		Resource sourceData = new ClassPathResource("data.json");
//
//		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
//		factory.setResources(new Resource[] { sourceData });
//		return factory;
//	}
}
