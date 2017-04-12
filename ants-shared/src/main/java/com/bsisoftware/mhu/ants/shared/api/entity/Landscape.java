package com.bsisoftware.mhu.ants.shared.api.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Landscape {

	@XmlElement(name="width")
	private int width;

	@XmlElement(name="height")
	private int height;

	@XmlElement(name="terrains")
	private List<Terrain> terrains = new ArrayList<>();
	
	public List<Terrain> getTerrains() {
		return Collections.unmodifiableList(terrains);
	}
	
	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
