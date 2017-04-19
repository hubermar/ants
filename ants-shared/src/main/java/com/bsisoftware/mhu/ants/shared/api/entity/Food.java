package com.bsisoftware.mhu.ants.shared.api.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Food extends GameObject {

	private static final Logger LOG = LoggerFactory.getLogger(Food.class);
	
	private int amount = 3;
	
	public void take() {
		amount--;
		LOG.info("new amount: " + amount);
	}
	
	public boolean isEmpty() {
		return amount < 1;
	}
	
	@Override
	public String toString() {
		return Food.class.getSimpleName() +	"[super=" + super.toString() + "]";
	}
}
