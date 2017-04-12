package com.bsisoftware.mhu.ants.javafx;

import java.util.List;

import com.bsisoftware.mhu.ants.javafx.rest.RestClient;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class RenderTimer extends AnimationTimer {

	private final GraphicsContext gc;
	private final RestClient server;
	private final double fieldSize;

	private long lastHandleSecs;
	
	public RenderTimer(RestClient server, GraphicsContext gc, double fieldSize) {
		this.server = server;
		this.gc = gc;
		this.fieldSize = fieldSize;
	}

	@Override
	public void handle(long currentNanoTime) {
		long currentSecs = currentNanoTime / 1000000000;
		if (currentSecs - lastHandleSecs > 0) {
			lastHandleSecs = currentSecs;
			System.out.println(currentSecs);
			renderTerrains(gc);
			// renderMen(gc);
			// renderMousePosition(gc);
			// renderPlayerPosition(gc);
		}
	}

	private void renderMousePosition(GraphicsContext gc) {
		// gc.setFill(Color.BLACK);
		// gc.fillRect(320, 400, 80, 20);
		// gc.setFill(Color.WHITE);
		// gc.setFont(new Font("Arial", 18.0));
		// gc.fillText(
		// String.format("M%03d/%03d", Double.valueOf(mouseX).intValue(),
		// Double.valueOf(mouseY).intValue()),
		// 320, 418);
	}

	private void renderPlayerPosition(GraphicsContext gc) {
		// gc.setFill(Color.BLACK);
		// gc.fillRect(0, 400, 80, 20);
		// gc.setFill(Color.WHITE);
		// gc.setFont(new Font("Arial", 18.0));
		// Point pos = server.getEngineModel().getPlayerPosition();
		// gc.fillText(String.format("P%03d/%03d", pos.getX(), pos.getY()), 0,
		// 418);
	}

	private void renderMen(GraphicsContext gc) {
		// for (IMan model : server.getEngineModel().getMen()) {
		// IRenderer renderer = RenderFactory.getRenderer(model);
		// renderer.render(gc);
		// }
	}

	private void renderTerrains(GraphicsContext gc) {
		List<Terrain> models = server.getLandscape().getTerrains();
		for (Terrain model : models) {
			// IRenderer renderer = RenderFactory.getRenderer(model);
			// renderer.render(gc);
			double x = model.getX() * fieldSize + 1;
			double y = model.getY() * fieldSize + 1;
			double w = fieldSize;
			double h = fieldSize;
			gc.clearRect(x, y, w, h);
			gc.setFill(Color.SANDYBROWN);
			gc.fillRect(x, y, w, h);
		}
	}
}