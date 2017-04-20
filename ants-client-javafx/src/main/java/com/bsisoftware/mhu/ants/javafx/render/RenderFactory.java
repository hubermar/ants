package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.server.api.Ant;
import com.bsisoftware.mhu.ants.server.api.Food;
import com.bsisoftware.mhu.ants.server.api.Hill;
import com.bsisoftware.mhu.ants.server.api.Terrain;
import com.bsisoftware.mhu.ants.shared.api.entity.IGameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.ITerrain;

public final class RenderFactory {

	private RenderFactory() { }

	public static IRenderer createRenderer(IGameObject model) {
		if (model instanceof Terrain) {
			return new TerrainRenderer((ITerrain) model);
		} else if (model instanceof Hill) {
			return new HillRenderer((Hill) model);
		} else if (model instanceof Food) {
			return new FoodRenderer((Food) model);
		} else if (model instanceof Ant) {
			return new AntRenderer((Ant) model);
		} else {
			return NullRenderer.INSTANCE;
		}
	}
}
