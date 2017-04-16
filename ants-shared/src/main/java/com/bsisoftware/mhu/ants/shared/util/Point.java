package com.bsisoftware.mhu.ants.shared.util;

public final class Point {

	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double distanceTo(Point p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2.0) + Math.pow(this.y - p.y, 2.0));
	}
	
	public Point translate(Point p) {
		Point newPos = new Point(this.x + p.x, this.y + p.y);
		// TODO ants should not leave from playground -> limit translation to playground
		return newPos;
	}
	
	public Point stepTowards(Point p, int stepSize) {
		double dx = p.getX() - x;
		double dy = p.getY() - y;
		double dir = Math.atan(dy / dx) * 2.0 * Math.PI;
		double stepX = Math.cos(dir) * stepSize;
		double stepY = Math.sin(dir) * stepSize;
		return new Point(Long.valueOf(Math.round(stepX)).intValue(), Long.valueOf(Math.round(stepY)).intValue());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		Point other = (Point) obj;
		if (x != other.x) { return false; }
		if (y != other.y) { return false; }
		return true;
	}

	@Override
	public String toString() {
		return Point.class.getSimpleName() + "[x=" + x + ", y=" + y + "]";
	}
}
