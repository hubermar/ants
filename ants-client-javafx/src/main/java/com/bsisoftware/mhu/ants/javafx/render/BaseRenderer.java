package com.bsisoftware.mhu.ants.javafx.render;

import com.bsisoftware.mhu.ants.shared.api.IGameObject;
import com.bsisoftware.mhu.ants.shared.util.Point;

import javafx.scene.canvas.GraphicsContext;

abstract class BaseRenderer<T extends IGameObject> implements IRenderer {

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
		Point p = RenderUtil.toScreen(pos);
		gc.fillRect(p.getX(), p.getY(), RenderUtil.getFieldSize(), RenderUtil.getFieldSize());
	}
	
	@Override
	public void render(GraphicsContext gc) {
		renderField(gc, model.getPosition(), bgPaint);
	}
}
