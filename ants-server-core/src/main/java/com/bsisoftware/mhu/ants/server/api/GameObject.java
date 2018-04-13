package com.bsisoftware.mhu.ants.server.api;

import javax.xml.bind.annotation.XmlElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.api.IGameObject;
import com.bsisoftware.mhu.ants.shared.util.Point;

public abstract class GameObject implements IGameObject {

	private static final Logger LOG = LoggerFactory.getLogger(GameObject.class);

	@XmlElement(name= "position")
	private Point position;
	
	private int width = DEFAULT_SIZE;
	private int height = DEFAULT_SIZE;

	@Override
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		LOG.debug(this.position + " -> " + position);
		this.position = position;
	}
	
	@Override
	public final int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public final int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public boolean intersects(Point p) {
		return Math.abs(p.getX() - position.getX()) <= width && Math.abs(p.getY() - position.getY()) <= height;
	}

	@Override
	public String toString() {
		return GameObject.class.getSimpleName() + "[position=" + position + " width=" + width + " height=" + height + "]";
	}
}
