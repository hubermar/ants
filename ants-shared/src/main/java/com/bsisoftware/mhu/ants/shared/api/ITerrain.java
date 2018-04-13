package com.bsisoftware.mhu.ants.shared.api;

public interface ITerrain extends IGameObject {

	public enum TerrainType {
		NEUTRAL
	}

	TerrainType getType();

}