package com.bsisoftware.mhu.ants.shared.model.landscape;

import com.bsisoftware.mhu.ants.shared.util.Point;

public interface ITerrain {

	Point getPosition();

	int getLevel();

	boolean isWater();
}
