package com.bsisoftware.mhu.ants.shared.api.entity;

public abstract class GameObject {

	private static final int DEFAULT_SIZE = 1;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	protected GameObject(int x, int y) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE);
	}

	protected GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}

	public final int getWidth() {
		return width;
	}

	public final int getHeight() {
		return height;
	}
}
