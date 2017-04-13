package com.bsisoftware.mhu.ants.server.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.bsisoftware.mhu.ants.shared.api.entity.Anthill;
import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.Landscape;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain.TerrainType;

public final class Engine {

	private static Anthill hill;

	private Engine() {}
	
	private static final Landscape landscape = new Landscape();

	static {
		initLandscape();
		placeAnthill();
	}
	
	private static void initLandscape() {
		landscape.setWidth(100);
		landscape.setHeight(100);
		List<Terrain> terrains = new ArrayList<>();
		for (int x = 0; x < landscape.getWidth(); x++) {
			for (int y = 0; y < landscape.getHeight(); y++) {
				Terrain terrain = new Terrain();
				terrain.setX(x);
				terrain.setY(y);
				terrain.setType(TerrainType.NEUTRAL);
				terrains.add(terrain);
			}			
		}
		landscape.setTerrains(terrains);
	}
	
	private static void placeAnthill() {
		Random random = new Random(System.currentTimeMillis());
		int hillX = Anthill.SIZE + random.nextInt(landscape.getWidth() - 2 * Anthill.SIZE);
		int hillY = Anthill.SIZE + random.nextInt(landscape.getHeight() - 2 * Anthill.SIZE);
		hill = new Anthill(hillX, hillY);
	}

	public static Landscape getLandscape() {
		return landscape;
	}
	
	public static List<GameObject> getObjects() {
		return Arrays.asList(hill);
	}

}
