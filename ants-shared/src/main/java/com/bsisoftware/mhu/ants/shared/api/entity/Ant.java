package com.bsisoftware.mhu.ants.shared.api.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.api.entity.IMovement.Transport;
import com.bsisoftware.mhu.ants.shared.util.Point;

public class Ant extends GameObject implements IPulseReceiver, ICollisionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(Ant.class);

	private static int STEP_SIZE = 1;
	
	private final String name;
	private final Hill home;
	
	private IMovement movement;
	
	public Ant(String name, Hill home) {
		this.name = name;
		this.home = home;
		this.movement = new IMovement.Search(home.getPosition());
		setPosition(home.getPosition());
	}
	
	public final String getName() {
		return name;
	}
	
	@Override
	public void handlePulse() {
		Point nextPosition = movement.getNextPosition(getPosition(), STEP_SIZE);
		setPosition(nextPosition);
	}
	
	@Override
	public void handleCollisionWith(GameObject o) {
		if (o instanceof Food) {
			LOG.info(name + ": found food");
			Food f = (Food) o;
			f.take();
			movement = new IMovement.Transport(o.getPosition(), home.getPosition(), f);
		} else if (o instanceof Hill) {
			LOG.info(name + ": arrived at hill");
			if (movement instanceof Transport) {
				Transport t = (Transport) movement;
				home.add(t.getPayload());
			}
		}
	}

	@Override
	public String toString() {
		return Ant.class.getSimpleName() + 
				"[super=" + super.toString() +
				" name=" + name + 
				" home=" + home + 
				" movement=" + movement + "]";
	}
}
