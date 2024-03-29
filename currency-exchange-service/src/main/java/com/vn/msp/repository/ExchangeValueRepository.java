package com.vn.msp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.msp.model.ExchangeValue;


public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);

}
