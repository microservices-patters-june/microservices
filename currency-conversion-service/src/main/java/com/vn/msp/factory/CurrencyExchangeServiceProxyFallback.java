package com.vn.msp.factory;

import java.math.BigDecimal;

import com.vn.msp.model.CurrencyConversionBean;
import com.vn.msp.proxy.CurrencyExchangeServiceProxy;

public class CurrencyExchangeServiceProxyFallback implements CurrencyExchangeServiceProxy {

	@Override
	public CurrencyConversionBean retrieveExchangeValue(String from, String to) {
		return new CurrencyConversionBean(0L, "EUR", "USD", new BigDecimal(1), new BigDecimal(1), new BigDecimal(1), 0);
	}

}
