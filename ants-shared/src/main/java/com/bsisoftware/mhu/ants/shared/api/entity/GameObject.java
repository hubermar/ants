package com.bsisoftware.mhu.ants.shared.api.entity;

import javax.xml.bind.annotation.XmlElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.util.Point;

public abstract class GameObject {

	private static final Logger LOG = LoggerFactory.getLogger(GameObject.class);

	public static final int DEFAULT_SIZE = 1;
	
	@XmlElement(name= "position")
	private Point position;
	
	private int width = DEFAULT_SIZE;
	private int height = DEFAULT_SIZE;
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		LOG.debug(this.position + " -> " + position);
		this.position = position;
	}
	
	public final int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public final int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean intersects(Point p) {
		return Math.abs(p.getX() - position.getX()) <= width && Math.abs(p.getY() - position.getY()) <= height;
	}

	@Override
	public String toString() {
		return GameObject.class.getSimpleName() + "[position=" + position + " width=" + width + " height=" + height + "]";
	}
}
