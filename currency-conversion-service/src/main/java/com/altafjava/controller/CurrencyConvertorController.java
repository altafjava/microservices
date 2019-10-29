package com.altafjava.controller;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.altafjava.dto.CurrencyConversion;
//import com.altafjava.proxy.CurrencyExchangeServiceProxy;
import com.altafjava.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConvertorController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new LinkedHashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		logger.info("currencyConversion= {}", currencyConversion);
		return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(),
				quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getPort());
	}

	@GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion currencyConversion = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
		logger.info("currencyConversion= {}", currencyConversion);
		return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(),
				quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getPort());
	}
}
