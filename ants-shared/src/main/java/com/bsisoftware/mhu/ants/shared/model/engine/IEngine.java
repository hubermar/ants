package com.bsisoftware.mhu.ants.shared.model.engine;

import java.util.Collection;

import com.bsisoftware.mhu.ants.shared.util.Point;

public interface IEngine {

	Collection<IMan> getMen();

	Point getPlayerPosition();

	void movePlayer(Point p);
}
