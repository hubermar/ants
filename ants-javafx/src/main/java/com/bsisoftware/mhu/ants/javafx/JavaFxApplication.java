package com.bsisoftware.mhu.ants.javafx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

	private static final Logger LOG = LoggerFactory.getLogger(JavaFxApplication.class);	
	
	private double mouseX = 0;
	private double mouseY = 0;

	private RenderTimer renderTimer;

	public JavaFxApplication() {
		initCommunication();
	}

	private void initCommunication() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Game");

		LOG.info("Preparing stage...");
		Canvas canvas = new Canvas(400, 420);

		Pane root = new Pane(canvas);
		Scene scene = new Scene(root);
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				mouseX = e.getSceneX();
				mouseY = e.getSceneY();
			}
		});

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				int x = 0, y = 0;
				switch (e.getCode()) {
				case LEFT:
					x = -1;
					break;
				case RIGHT:
					x = 1;
					break;
				case UP:
					y = -1;
					break;
				case DOWN:
					y = 1;
					break;
				case NUMPAD1:
					x = -1;
					y = 1;
					break;
				case NUMPAD2:
					y = 1;
					break;
				case NUMPAD3:
					x = 1;
					y = 1;
					break;
				case NUMPAD4:
					x = -1;
					break;
				case NUMPAD6:
					x = 1;
					break;
				case NUMPAD7:
					x = -1;
					y = -1;
					break;
				case NUMPAD8:
					y = -1;
					break;
				case NUMPAD9:
					x = 1;
					y = -1;
					break;
				default:
				}
//				server.getEngineModel().movePlayer(new Point(x, y));
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		LOG.info("stage ready.");

		LOG.info("starting renderer ...");
		renderTimer = new RenderTimer(canvas.getGraphicsContext2D());
		renderTimer.start();

		LOG.info("game running.");
	}

	@Override
	public void stop() throws Exception {
		LOG.info("stopping renderer...");
		renderTimer.stop();
		LOG.info("stopping application...");
		super.stop();
		LOG.info("end of application.");
	}

	public static void main(String[] args) {
		launch(args);
	}

	private class RenderTimer extends AnimationTimer {

		private final GraphicsContext gc;

		public RenderTimer(GraphicsContext gc) {
			this.gc = gc;
		}

		@Override
		public void handle(long currentNanoTime) {
			gc.clearRect(0, 0, 400, 400);
			renderTerrains(gc);
			renderMen(gc);
			renderMousePosition(gc);
			renderPlayerPosition(gc);
		}

		private void renderMousePosition(GraphicsContext gc) {
			gc.setFill(Color.BLACK);
			gc.fillRect(320, 400, 80, 20);
			gc.setFill(Color.WHITE);
			gc.setFont(new Font("Arial", 18.0));
			gc.fillText(
					String.format("M%03d/%03d", Double.valueOf(mouseX).intValue(), Double.valueOf(mouseY).intValue()),
					320, 418);
		}

		private void renderPlayerPosition(GraphicsContext gc) {
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 400, 80, 20);
			gc.setFill(Color.WHITE);
			gc.setFont(new Font("Arial", 18.0));
//			Point pos = server.getEngineModel().getPlayerPosition();
//			gc.fillText(String.format("P%03d/%03d", pos.getX(), pos.getY()), 0, 418);
		}

		private void renderMen(GraphicsContext gc) {
//			for (IMan model : server.getEngineModel().getMen()) {
//				IRenderer renderer = RenderFactory.getRenderer(model);
//				renderer.render(gc);
//			}
		}

		private void renderTerrains(GraphicsContext gc) {
//			for (ITerrain model : server.getLandscapeModel().getTerrains()) {
//				IRenderer renderer = RenderFactory.getRenderer(model);
//				renderer.render(gc);
//			}
		}
	}
}
