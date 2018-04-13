package com.bsisoftware.mhu.ants.shared.api;

import com.bsisoftware.mhu.ants.shared.util.Point;

public interface IGameObject {

	int DEFAULT_SIZE = 1;
	
	Point getPosition();

	int getWidth();

	int getHeight();

	boolean intersects(Point p);

}