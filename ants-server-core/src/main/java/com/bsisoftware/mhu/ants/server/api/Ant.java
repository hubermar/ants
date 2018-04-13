package com.bsisoftware.mhu.ants.server.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.server.ICollisionHandler;
import com.bsisoftware.mhu.ants.server.IMovement;
import com.bsisoftware.mhu.ants.server.IPulseReceiver;
import com.bsisoftware.mhu.ants.server.IMovement.Transport;
import com.bsisoftware.mhu.ants.shared.api.IGameObject;
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
	public void handleCollisionWith(IGameObject o) {
		if (o instanceof Food) {
			handleFood((Food) o);
		} else if (o instanceof Hill) {
			handleHill((Hill) o);
		} else if (o instanceof Ant) {
			handleAnt((Ant) o);
		}
	}

	private void handleAnt(Ant a) {
		if (a.home != home) {
			fight(a);
		}
	}

	private void handleHill(Hill h) {
		// TODO handle hostile hill
		if (movement instanceof Transport) {
			Transport t = (Transport) movement;
			home.add(t.getPayload());
			LOG.info(name + ": delivered payload " + t.getPayload());
		}
		movement = new IMovement.Search(home.getPosition());
	}

	private void handleFood(Food f) {
		LOG.info(name + ": found food");
		f.take();
		movement = new IMovement.Transport(home.getPosition(), f);
	}

	private void fight(Ant a) {
		LOG.info(name + " encounters " + a.name + " -> fight!!!");		
		// TODO implement fight
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
