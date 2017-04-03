package com.bsisoftware.mhu.ants.shared.model.landscape;

import java.util.Collection;

import com.bsisoftware.mhu.ants.shared.util.Point;

public interface ILandscape {

	int getWidth();

	int getHeight();

	Collection<ITerrain> getTerrains();

	ITerrain getTerrain(Point p);
}
