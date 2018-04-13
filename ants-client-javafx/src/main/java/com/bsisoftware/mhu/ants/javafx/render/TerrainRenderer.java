package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.api.ITerrain;

class TerrainRenderer extends BaseRenderer<ITerrain> {

	public TerrainRenderer(ITerrain model) {
		super(model, AntsPaint.TERRAIN_NEUTRAL);
	}	
}
