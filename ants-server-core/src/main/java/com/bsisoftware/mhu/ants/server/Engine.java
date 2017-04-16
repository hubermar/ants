package com.bsisoftware.mhu.ants.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.api.entity.Ant;
import com.bsisoftware.mhu.ants.shared.api.entity.Hill;
import com.bsisoftware.mhu.ants.shared.api.entity.Food;
import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.Landscape;
import com.bsisoftware.mhu.ants.shared.api.entity.IPulseReceiver;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain.TerrainType;
import com.bsisoftware.mhu.ants.shared.util.Point;
import com.bsisoftware.mhu.ants.shared.util.RandomUtil;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

public final class Engine {
	
	private static final Logger LOG = LoggerFactory.getLogger(Engine.class);
	
	public static Engine INSTANCE = new Engine();

	private final Timer timer = new Timer();
	private final Landscape landscape = new Landscape();
	private final List<Ant> ants = new ArrayList<>();
	private final List<Food> foods = new ArrayList<>();
	private final List<Hill> hills = new ArrayList<>();
	
	private Engine() {
		initLandscape();
		Hill hill = createAnthill();
		createAnts(hill);
		placeFoods();
	}
	
	public void start() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				pulse();
			}
		}, 100, 100);
	}

	public void stop() {
		timer.cancel();
		timer.purge();
	}

	private void initLandscape() {
		landscape.setWidth(StaticConfiguration.getInt(StaticConfiguration.LANDSCAPE_WIDTH));
		landscape.setHeight(StaticConfiguration.getInt(StaticConfiguration.LANDSCAPE_HEIGHT));
		List<Terrain> terrains = new ArrayList<>();
		for (int x = 0; x < landscape.getWidth(); x++) {
			for (int y = 0; y < landscape.getHeight(); y++) {
				Terrain terrain = new Terrain();
				terrain.setPosition(new Point(x, y));
				terrain.setType(TerrainType.NEUTRAL);
				terrains.add(terrain);
			}			
		}
		landscape.setTerrains(terrains);
	}
	
	private void createAnts(Hill hill) {
		int nbrAnts = StaticConfiguration.getInt(StaticConfiguration.NBR_ANTS);
		for (int i = 0; i < nbrAnts; i++) {
			Ant ant = new Ant("Ant" + i, hill);
			ants.add(ant);
		}
	}

	private void placeFoods() {
		int nbrFood = StaticConfiguration.getInt(StaticConfiguration.NBR_FOOD);
		for (int i = 0; i < nbrFood; i++) {
			Point pos = RandomUtil.createPosition();
			Food food = new Food();
			food.setPosition(pos);
			foods.add(food);
		}
	}

	private Hill createAnthill() {
		Point pos = RandomUtil.createPosition(Hill.SIZE, Hill.SIZE);
		Hill hill = new Hill();
		hill.setPosition(pos);
		LOG.info("created hill=" + hill);
		hills.add(hill);
		return hill;
	}

	public Landscape getLandscape() {
		return landscape;
	}
	
	public List<GameObject> getObjects() {
		List<GameObject> objects = new ArrayList<>();
		objects.addAll(hills);
		objects.addAll(foods);
		objects.addAll(ants);
		return Collections.unmodifiableList(objects);
	}

	private void pulse() {
		sendPulse();
		checkCollisions();
		cleanup();
	}

	private void cleanup() {
		ListIterator<Food> it = foods.listIterator();
		while (it.hasNext()) {
			if (it.next().isEmpty()) {
				it.remove();
			}
		}
	}

	private void checkCollisions() {
		for (Ant ant : ants) {
			for (Food food : foods) {
				if (food.getPosition().equals(ant.getPosition())) {
					ant.handleCollisionWith(food);
				}
			}
		}
	}

	private void sendPulse() {
		for (GameObject object : getObjects()) {
			if (object instanceof IPulseReceiver) {
				IPulseReceiver pr = (IPulseReceiver) object;
				pr.handlePulse();
			}
		}
	}

}
