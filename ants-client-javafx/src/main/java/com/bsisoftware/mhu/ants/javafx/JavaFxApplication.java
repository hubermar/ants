package com.bsisoftware.mhu.ants.javafx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.javafx.rest.AntsClient;
import com.bsisoftware.mhu.ants.shared.api.AntsAPI;
import com.bsisoftware.mhu.ants.shared.api.LandscapeDTO;
import com.bsisoftware.mhu.ants.shared.exception.AntsRemoteException;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;
import com.bsisoftware.mhu.ants.shared.util.UriUtil;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

	private static final Logger LOG = LoggerFactory.getLogger(JavaFxApplication.class);	
	
	private double mouseX = 0;
	private double mouseY = 0;

	private RenderTimer renderTimer;
	private AntsAPI server;
	
	public JavaFxApplication() {
		initCommunication();
	}

	private void initCommunication() {
		String serverPort = StaticConfiguration.getString(StaticConfiguration.SERVER_PORT);
		String serverAddress = "http://localhost:" + serverPort + "/" + UriUtil.CONTEXT + UriUtil.PREFIX + UriUtil.VERSION;
		server = new AntsClient(serverAddress, "user", "password");
	}

	@Override
	public void start(Stage primaryStage) {
		try {
		primaryStage.setFullScreen(true);
		primaryStage.setTitle("Ants");
		
		LOG.info("Preparing stage...");
		LandscapeDTO landscape = server.getLandscape();

		Canvas canvas = new Canvas(2800, 1600);

		VBox vbox = new VBox(canvas);
		ScrollPane root = new ScrollPane(vbox);

		root.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		root.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		Scene scene = new Scene(root);
        
//		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				mouseX = e.getSceneX();
//				mouseY = e.getSceneY();
//			}
//		});

//		scene.setOnKeyPressed(new KeyHandler());
		primaryStage.setScene(scene);
		primaryStage.show();
		LOG.info("stage ready.");

		LOG.info("starting renderer ...");
		renderTimer = new RenderTimer(canvas.getGraphicsContext2D());
		renderTimer.start();

		LOG.info("game running.");
		} catch (AntsRemoteException e) {
			LOG.error("Caught remote exceptiion.", e);
		}
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
			gc.clearRect(0, 0, 800, 400);
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
