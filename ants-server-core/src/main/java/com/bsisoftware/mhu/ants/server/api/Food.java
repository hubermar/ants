package com.bsisoftware.mhu.ants.server.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Food extends GameObject {

	private static final Logger LOG = LoggerFactory.getLogger(Food.class);
	
	private int amount;
	
	public Food(int amount) {
		this.amount = amount;
	}
	
	public Food take() {
		amount--;
		LOG.info("new amount: " + amount);
		return new Food(1);
	}
	
	public boolean isEmpty() {
		return amount < 1;
	}
	
	@Override
	public String toString() {
		return Food.class.getSimpleName() +	"[super=" + super.toString() + "]";
	}
}
