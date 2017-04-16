package com.bsisoftware.mhu.ants.shared.api.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hill extends GameObject {

	private static Logger LOG = LoggerFactory.getLogger(Hill.class);
	
	public static final int SIZE = 4;

	public Hill() {
		setWidth(SIZE);
		setHeight(SIZE);
	}

	public void add(Food payload) {
		LOG.info("Food added");
	}
}
