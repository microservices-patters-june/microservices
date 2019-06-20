package com.vn.msp.factory;

import org.springframework.stereotype.Component;

import com.vn.msp.proxy.CurrencyExchangeServiceProxy;

import feign.hystrix.FallbackFactory;

@Component
public class CurrencyExchangeServiceProxyFallbackFactory implements FallbackFactory<CurrencyExchangeServiceProxy> {

	@Override
	public CurrencyExchangeServiceProxy create(Throwable cause) {
		return new CurrencyExchangeServiceProxyFallback();
	}

}
