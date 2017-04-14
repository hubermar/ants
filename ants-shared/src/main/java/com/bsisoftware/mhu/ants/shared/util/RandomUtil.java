package com.bsisoftware.mhu.ants.shared.util;

import java.util.Random;

import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;

public final class RandomUtil {

	private static final Random R = new Random(System.currentTimeMillis());

	public static Point createPosition(int width, int height) {
		int x = width + R.nextInt(StaticConfiguration.getInt(StaticConfiguration.LANDSCAPE_WIDTH) - 2 * width);
		int y = height + R.nextInt(StaticConfiguration.getInt(StaticConfiguration.LANDSCAPE_HEIGHT) - 2 * height);
		return new Point(x, y);
	}
	
	public static Point createPosition() {
		return createPosition(GameObject.DEFAULT_SIZE, GameObject.DEFAULT_SIZE);
	}

	/**
	 * provides a translation in a random direction with the given distance.
	 * @param distance
	 * @return
	 */
	public static Point createTranslation(int distance) {
		int x = -1 + R.nextInt(2);
		int y = -1 + R.nextInt(2);
		return new Point(x * distance, y * distance);
	}
	
	private RandomUtil() { }
}
