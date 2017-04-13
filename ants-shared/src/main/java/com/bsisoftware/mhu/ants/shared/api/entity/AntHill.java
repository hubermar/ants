package com.bsisoftware.mhu.ants.shared.api.entity;

import com.bsisoftware.mhu.ants.shared.util.Point;

public class AntHill extends GameObject {

	public static final int SIZE = 4;

	public AntHill(Point position) {
		super(position, SIZE, SIZE);
	}

}
