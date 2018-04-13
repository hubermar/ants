package com.bsisoftware.mhu.ants.server.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.bsisoftware.mhu.ants.shared.api.ITerrain;

@XmlAccessorType(XmlAccessType.FIELD)
public class Terrain extends GameObject implements ITerrain {

	@XmlElement(name= "type")
	private TerrainType type;

	@Override
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
