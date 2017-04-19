package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.util.Point;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

public final class RenderUtil {

	private RenderUtil() { }
	
	private static final int FIELD_SIZE = StaticConfiguration.getInt(StaticConfiguration.FIELD_SIZE);

	public static final int getFieldSize() {
		return FIELD_SIZE;
	}

	public static final Point toScreen(Point p) {
		return new Point(p.getX() * FIELD_SIZE, p.getY() * FIELD_SIZE);
	}
}
