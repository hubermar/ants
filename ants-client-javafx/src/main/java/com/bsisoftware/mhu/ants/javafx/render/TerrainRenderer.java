package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.api.entity.Terrain;

class TerrainRenderer extends BaseRenderer<Terrain> {

	public TerrainRenderer(Terrain model) {
		super(model, AntsPaint.TERRAIN_NEUTRAL);
	}	
}
