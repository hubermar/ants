package com.bsisoftware.mhu.ants.shared.api.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Terrain {

	public enum TerrainType {
		NEUTRAL
	}

	@XmlElement(name= "x")
	private int x;
	
	@XmlElement(name= "y")
	private int y;

	@XmlElement(name= "type")
	private TerrainType type;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public TerrainType getType() {
		return type;
	}

	public void setType(TerrainType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return Terrain.class.getSimpleName() + "[x=" + x + " y=" + y + " type=" + type + "]";
	}
}
