package com.bsisoftware.mhu.ants.shared.api.entity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hill extends GameObject {

	private static Logger LOG = LoggerFactory.getLogger(Hill.class);
	
	public static final int SIZE = 4;
	
	private final List<Food> stock = new ArrayList<>();

	public Hill() {
		setWidth(SIZE);
		setHeight(SIZE);
	}

	public void add(Food food) {
		stock.add(food);
		LOG.info("Food added, new stock: " + stock.size());
	}
}
