package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.api.entity.Hill;
import com.bsisoftware.mhu.ants.shared.util.Point;

import javafx.scene.canvas.GraphicsContext;

class HillRenderer extends BaseRenderer<Hill> {

	public HillRenderer(Hill model) {
		super(model, AntsPaint.ANTHILL);
	}

	@Override
	public void render(GraphicsContext gc) {
		int width = getModel().getWidth();
		int height = getModel().getHeight();
		Point center = new Point(getModel().getPosition().getX() - width / 2, getModel().getPosition().getY() - height / 2);
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				Point p = center.translate(new Point(w, h));
				renderField(gc, p, AntsPaint.ANTHILL);
			}			
		}
	}

}
