package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.api.entity.Ant;
import com.bsisoftware.mhu.ants.shared.api.entity.Hill;
import com.bsisoftware.mhu.ants.shared.api.entity.Food;
import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain;

public final class RenderFactory {

	private RenderFactory() { }

	public static IRenderer createRenderer(GameObject model) {
		if (model instanceof Terrain) {
			return new TerrainRenderer((Terrain) model);
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
