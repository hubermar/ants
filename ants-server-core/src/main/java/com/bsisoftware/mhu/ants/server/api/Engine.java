package com.bsisoftware.mhu.ants.server.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.bsisoftware.mhu.ants.shared.api.entity.Ant;
import com.bsisoftware.mhu.ants.shared.api.entity.AntHill;
import com.bsisoftware.mhu.ants.shared.api.entity.Food;
import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.Landscape;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain.TerrainType;
import com.bsisoftware.mhu.ants.shared.util.Point;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

public final class Engine {
	
	private static final Random R = new Random(System.currentTimeMillis());

	public static Engine INSTANCE = new Engine();

	private final Landscape landscape = new Landscape();
	private final List<Ant> ants = new ArrayList<>();
	private final List<Food> foods = new ArrayList<>();
	private final List<AntHill> hills = new ArrayList<>();
	
	private Engine() {
		initLandscape();
		placeAnthill();
		placeFoods();
		createAnts();
	}
	
	private void initLandscape() {
		landscape.setWidth(100);
		landscape.setHeight(100);
		List<Terrain> terrains = new ArrayList<>();
		for (int x = 0; x < landscape.getWidth(); x++) {
			for (int y = 0; y < landscape.getHeight(); y++) {
				Terrain terrain = new Terrain(new Point(x, y));
				terrain.setType(TerrainType.NEUTRAL);
				terrains.add(terrain);
			}			
		}
		landscape.setTerrains(terrains);
	}
	
	private void createAnts() {
		int nbrAnts = StaticConfiguration.getInt(StaticConfiguration.NBR_ANTS);
		for (int i = 0; i < nbrAnts; i++) {
			Point pos = createRandomPos();
			Ant ant = new Ant(pos);
			ants.add(ant);
		}
	}

	private void placeFoods() {
		int nbrFood = StaticConfiguration.getInt(StaticConfiguration.NBR_FOOD);
		for (int i = 0; i < nbrFood; i++) {
			Point pos = createRandomPos();
			Food food = new Food(pos);
			foods.add(food);
		}
	}

	private void placeAnthill() {
		Point pos = createRandomPos(AntHill.SIZE, AntHill.SIZE);
		hills.add(new AntHill(pos));
	}

	private Point createRandomPos(int width, int height) {
		int x = width + R.nextInt(landscape.getWidth() - 2 * width);
		int y = height + R.nextInt(landscape.getHeight() - 2 * height);
		return new Point(x, y);
	}
	
	private Point createRandomPos() {
		return createRandomPos(GameObject.DEFAULT_SIZE, GameObject.DEFAULT_SIZE);
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

}
