package com.bsisoftware.mhu.ants.javafx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.server.Server;
import com.bsisoftware.mhu.ants.shared.exception.AntsRemoteException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

	private static final Logger LOG = LoggerFactory.getLogger(JavaFxApplication.class);

	private static final int INITIAL_WIDTH = 1000;
	private static final int INITIAL_HEIGHT = 1000;

	private double mouseX = 0;
	private double mouseY = 0;

	private RenderTimer renderTimer;

	public JavaFxApplication() {
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// primaryStage.setFullScreen(true);
			primaryStage.setTitle("Ants");

			Server server = new Server();

			LOG.info("Preparing stage...");
			
			Canvas canvas = new Canvas(INITIAL_WIDTH, INITIAL_HEIGHT);
			VBox vbox = new VBox(canvas);
			ScrollPane root = new ScrollPane(vbox);

			root.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
			root.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

			Scene scene = new Scene(root);

			// scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			// @Override
			// public void handle(MouseEvent e) {
			// mouseX = e.getSceneX();
			// mouseY = e.getSceneY();
			// }
			// });

			// scene.setOnKeyPressed(new KeyHandler());
			primaryStage.setScene(scene);
			primaryStage.show();
			LOG.info("stage ready.");

			LOG.info("starting renderer ...");
			renderTimer = new RenderTimer(server, canvas.getGraphicsContext2D());
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
}
