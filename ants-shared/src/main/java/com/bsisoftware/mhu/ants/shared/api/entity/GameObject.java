package com.bsisoftware.mhu.ants.shared.api.entity;

import javax.xml.bind.annotation.XmlElement;

import com.bsisoftware.mhu.ants.shared.util.Point;

public abstract class GameObject implements PulseReceiver {

	public static final int DEFAULT_SIZE = 1;
	
	@XmlElement(name= "position")
	private Point position;
	
	private Track track = new Track();
	private int width = DEFAULT_SIZE;
	private int height = DEFAULT_SIZE;
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
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

	public Track getTrack() {
		return track;
	}
	
	public void pulse() { }

	@Override
	public String toString() {
		return GameObject.class.getSimpleName() + "[position=" + position + " width=" + width + " height=" + height + "]";
	}
}
