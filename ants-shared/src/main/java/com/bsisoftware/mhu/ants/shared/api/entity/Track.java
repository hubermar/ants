package com.bsisoftware.mhu.ants.shared.api.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bsisoftware.mhu.ants.shared.util.Point;

public class Track {

	private List<Point> points = new ArrayList<>();
	private int index;
	
	public void forward(Point p) {
		points.add(index++, p);
	}
	
	public Point back() {
		return points.get(index--);
	}
	
	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}
}
