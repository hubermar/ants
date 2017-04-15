package com.bsisoftware.mhu.ants.javafx;

import java.util.List;

import com.bsisoftware.mhu.ants.javafx.render.IRenderer;
import com.bsisoftware.mhu.ants.javafx.render.RenderFactory;
import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.Terrain;
import com.bsisoftware.mhu.ants.shared.server.IServer;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

class RenderTimer extends AnimationTimer {

	private final GraphicsContext gc;
	private final IServer server;

	private long lastHandleSecs;

	public RenderTimer(IServer server, GraphicsContext gc) {
		this.server = server;
		this.gc = gc;
	}

	@Override
	public void handle(long currentNanoTime) {
		long currentSecs = currentNanoTime; // / 1000000000;
		if (currentSecs - lastHandleSecs > 0) {
			lastHandleSecs = currentSecs;
			renderTerrains(gc);
			renderObjects(gc);
			// renderMen(gc);
			// renderMousePosition(gc);
			// renderPlayerPosition(gc);
		}
	}

	private void renderObjects(GraphicsContext gc) {
		for (GameObject object : server.getObjects()) {
			IRenderer renderer = RenderFactory.createRenderer(object);
			renderer.render(gc);
		}
	}

	private void renderTerrains(GraphicsContext gc) {
		List<Terrain> models = server.getLandscape().getTerrains();
		for (Terrain model : models) {
			IRenderer renderer = RenderFactory.createRenderer(model);
			renderer.render(gc);
		}
	}
}