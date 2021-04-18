package com.amarispedro.lab.price.domain.exception;

public class MoreThanOnePriceFound extends RuntimeException {

	private static final long serialVersionUID = 5477594733477223868L;

	public MoreThanOnePriceFound() {
		super("Multiple Prices Found");
	}
}
