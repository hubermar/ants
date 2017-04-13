package com.bsisoftware.mhu.ants.javafx.render;

import javafx.scene.canvas.GraphicsContext;

public class NullRenderer implements IRenderer {

	public static final NullRenderer INSTANCE = new NullRenderer();
	
	private NullRenderer() { }
	
	@Override
	public void render(GraphicsContext gc) {
	}

}
