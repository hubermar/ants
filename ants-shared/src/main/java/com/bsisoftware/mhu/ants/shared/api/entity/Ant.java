package com.bsisoftware.mhu.ants.shared.api.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.util.Point;
import com.bsisoftware.mhu.ants.shared.util.RandomUtil;

public class Ant extends GameObject {

	private static final Logger LOG = LoggerFactory.getLogger(Ant.class);

	private final AntHill hill;

	public Ant(AntHill hill) {
		this.hill = hill;
		setPosition(hill.getPosition());
	}
	
	@Override
	public void pulse() {
		LOG.info("called");
		Point tr = RandomUtil.createTranslation(1);
		Point newPos = getPosition().translate(tr);
		getTrack().forward(newPos);
		setPosition(newPos);
	}
}
