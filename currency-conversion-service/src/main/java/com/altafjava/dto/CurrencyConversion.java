package com.altafjava.dto;

import java.math.BigDecimal;

public class CurrencyConversion {
	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quanity;
	private BigDecimal calculatedAmount;
	private int port;

	public CurrencyConversion() {
		super();
	}

	public CurrencyConversion(int id, String from, String to, BigDecimal conversionMultiple, BigDecimal quanity,
			BigDecimal calculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quanity = quanity;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuanity() {
		return quanity;
	}

	public void setQuanity(BigDecimal quanity) {
		this.quanity = quanity;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
