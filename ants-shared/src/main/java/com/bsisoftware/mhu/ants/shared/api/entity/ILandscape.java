package com.bsisoftware.mhu.ants.shared.api.entity;

import java.util.List;

public interface ILandscape {

	List<ITerrain> getTerrains();

	int getHeight();

	void setHeight(int height);

	int getWidth();

}