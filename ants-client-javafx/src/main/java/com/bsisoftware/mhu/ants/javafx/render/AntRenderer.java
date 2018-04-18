package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.server.api.Ant;
import com.bsisoftware.mhu.ants.server.api.Food;
import com.bsisoftware.mhu.ants.shared.api.IGameObject;
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
		renderPayload(gc);
		Point p = RenderUtil.toScreen(getModel().getPosition().translate(new Point(-1, -1)));
		gc.setStroke(Color.BLACK);
		gc.strokeText(getModel().getName(), p.getX(), p.getY());
	}

	private void renderPayload(GraphicsContext gc) {
		IGameObject payload = getModel().getPayload();
		if (payload != null && payload instanceof Food) {
			gc.setFill(AntsPaint.FOOD.getPaint());
			Point p = RenderUtil.toScreen(getModel().getPosition());
			gc.fillRect(p.getX() + 1, p.getY() + 1, RenderUtil.getFieldSize() - 2, RenderUtil.getFieldSize() - 2);
		}		
	}
}
