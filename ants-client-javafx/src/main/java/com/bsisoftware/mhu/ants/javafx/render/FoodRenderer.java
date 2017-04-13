package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.api.entity.Food;

public class FoodRenderer extends BaseRenderer<Food> {

	public FoodRenderer(Food model) {
		super(model, AntsPaint.FOOD);
	}
}
