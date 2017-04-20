package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.server.api.Ant;
import com.bsisoftware.mhu.ants.shared.util.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AntRenderer extends BaseRenderer<Ant> {

	public AntRenderer(Ant model) {
		super(model, AntsPaint.ANT);
	}

	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
		Point p = RenderUtil.toScreen(getModel().getPosition().translate(new Point(-1, -1)));
		gc.setStroke(Color.BLACK);
		gc.strokeText(getModel().getName(), p.getX(), p.getY());
	}
}
