package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.util.Point;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

import javafx.scene.canvas.GraphicsContext;

abstract class BaseRenderer<T extends GameObject> implements IRenderer {

	private static final int FIELD_SIZE = StaticConfiguration.getInt(StaticConfiguration.FIELD_SIZE);

	private final T model;
	private final AntsPaint bgPaint;
	
	protected BaseRenderer(T model, AntsPaint bgPaint) {
		this.model = model;
		this.bgPaint = bgPaint;
	}
	
	protected final T getModel() {
		return model;
	}
	
	protected final void renderField(GraphicsContext gc, Point pos, AntsPaint color) {
		gc.setFill(color.getPaint());
		gc.fillRect(pos.getX() * FIELD_SIZE, pos.getY() * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE);
	}
	
	@Override
	public void render(GraphicsContext gc) {
		renderField(gc, model.getPosition(), bgPaint);
	}
}
