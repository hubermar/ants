package com.bsisoftware.mhu.ants.javafx.render;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

enum AntsPaint {
	TERRAIN_NEUTRAL(Color.DARKKHAKI), 
	ANTHILL(Color.SANDYBROWN),
	FOOD(Color.ORANGE),
	ANT(Color.BLACK);
	
	private final Paint paint;

	AntsPaint(Paint paint) {
		this.paint = paint;
	}

	public Paint getPaint() {
		return paint;
	}
}
