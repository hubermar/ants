package com.bsisoftware.mhu.ants.shared.api.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Terrain extends GameObject {

	public enum TerrainType {
		NEUTRAL
	}

	@XmlElement(name= "type")
	private TerrainType type;

	public TerrainType getType() {
		return type;
	}

	public void setType(TerrainType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return Terrain.class.getSimpleName() + "[super=" + super.toString() + " type=" + type + "]";
	}
}
