package com.bsisoftware.mhu.ants.shared.api.entity;

import javax.xml.bind.annotation.XmlElement;

import com.bsisoftware.mhu.ants.shared.util.Point;

public abstract class GameObject {

	public static final int DEFAULT_SIZE = 1;
	
	@XmlElement(name= "position")
	private Point position;
	
	private int width;
	private int height;
	
	/**
	 * for jaxrs 
	 */
	protected GameObject() { }

	protected GameObject(Point position) {
		this(position, DEFAULT_SIZE, DEFAULT_SIZE);
	}

	protected GameObject(Point position, int width, int height) {
		this.position = position;
		this.width = width;
		this.height = height;
	}

	public Point getPosition() {
		return position;
	}

	public final int getWidth() {
		return width;
	}

	public final int getHeight() {
		return height;
	}
}
