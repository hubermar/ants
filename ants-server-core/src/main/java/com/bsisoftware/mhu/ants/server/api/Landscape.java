package com.bsisoftware.mhu.ants.server.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bsisoftware.mhu.ants.shared.api.entity.ILandscape;
import com.bsisoftware.mhu.ants.shared.api.entity.ITerrain;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Landscape implements ILandscape {

	@XmlElement(name="width")
	private int width;

	@XmlElement(name="height")
	private int height;

	@XmlElement(name="terrains")
	private List<Terrain> terrains = new ArrayList<>();
	
	@Override
	public List<ITerrain> getTerrains() {
		return Collections.unmodifiableList(terrains);
	}
	
	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
