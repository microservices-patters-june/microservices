package com.vn.msp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vn.msp.model.ExchangeValue;


public interface ExchangeValueRepository extends MongoRepository<ExchangeValue, String> {

	public ExchangeValue findByFromAndTo(String from, String to);

}
