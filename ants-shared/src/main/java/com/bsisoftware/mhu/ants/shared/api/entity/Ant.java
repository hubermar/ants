package com.bsisoftware.mhu.ants.shared.api.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.util.Point;
import com.bsisoftware.mhu.ants.shared.util.RandomUtil;

public class Ant extends GameObject implements IPulseReceiver, ICollisionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(Ant.class);

	private static int STEP_SIZE = 1;
	
	enum Mode {
		SEARCH,
		GOTO
	}
	
	private final String name;
	private final Hill home;
	
	private GameObject origin;
	private GameObject target;
	private Mode mode;

	public Ant(String name, Hill home) {
		this.name = name;
		this.home = home;
		origin = home;
		mode = Mode.SEARCH;
		setPosition(home.getPosition());
	}
	
	public final String getName() {
		return name;
	}
	
	@Override
	public void pulse() {
		switch (mode) {
		case SEARCH:
			searchFood();
			break;
		case GOTO:
			goToTarget();
			break;
		default:
			throw new IllegalStateException("illegal mode " + mode);
		}
	}
	
	private void goToTarget() {
		Point move = getPosition().stepTowards(target.getPosition(), STEP_SIZE);
		Point newPos = getPosition().translate(move);
		setPosition(newPos);
	}

	private void searchFood() {
		Point tr = RandomUtil.createTranslation(STEP_SIZE);
		Point newPos = getPosition().translate(tr);
		setPosition(newPos);
	}

	@Override
	public void handleCollisionWith(GameObject o) {
		if (o instanceof Food) {
			LOG.info(name + ": found food");
			origin = o;
			target = home;
			mode = Mode.GOTO;
		} else if (o instanceof Hill) {
			LOG.info(name + ": arrived at hill");
			// TODO "unload" payload, search again
			origin = home;
			mode = Mode.SEARCH;
		}
	}
}
