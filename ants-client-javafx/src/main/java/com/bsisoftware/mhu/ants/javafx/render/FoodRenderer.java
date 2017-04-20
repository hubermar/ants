package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.server.api.Food;

public class FoodRenderer extends BaseRenderer<Food> {

	public FoodRenderer(Food model) {
		super(model, AntsPaint.FOOD);
	}
}
