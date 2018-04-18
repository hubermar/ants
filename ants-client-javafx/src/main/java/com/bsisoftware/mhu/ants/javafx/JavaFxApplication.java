package com.bsisoftware.mhu.ants.javafx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.javafx.render.RenderUtil;
import com.bsisoftware.mhu.ants.server.Server;
import com.bsisoftware.mhu.ants.shared.exception.AntsRemoteException;
import com.bsisoftware.mhu.ants.shared.util.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

	private static final Logger LOG = LoggerFactory.getLogger(JavaFxApplication.class);

	private static final int INITIAL_WIDTH = 1000;
	private static final int INITIAL_HEIGHT = 1000;

	private final Server server = new Server();
	private RenderTimer renderTimer;

	public JavaFxApplication() { }

	@Override
	public void start(Stage primaryStage) {
		server.start();
		try {
			LOG.info("Preparing stage...");
			// primaryStage.setFullScreen(true);
			primaryStage.setTitle("Ants");
			
			final Canvas canvas = new Canvas(INITIAL_WIDTH, INITIAL_HEIGHT);
			VBox vbox = new VBox(canvas);
			ScrollPane root = new ScrollPane(vbox);

			root.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
			root.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

			Scene scene = new Scene(root);
			scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
//					System.out.println("mouse scene: (" + e.getSceneX() + ", " + e.getSceneY() + ")");
//					System.out.println("mouse screen: (" + e.getScreenX() + ", " + e.getScreenY() + ")");
					System.out.println(RenderUtil.fromScreen(new Point(Double.valueOf(e.getSceneX()).intValue(), Double.valueOf(e.getSceneY()).intValue())));
					canvas.getGraphicsContext2D().setFill(Color.WHITESMOKE);
					canvas.getGraphicsContext2D().fillText("(" + e.getSceneX() + "," + e.getSceneY() + ")", 400, 400);
				}
			});

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
		LOG.info("detaching from server...");
		server.stop();
		LOG.info("stopping application...");
		super.stop();
		LOG.info("end of application.");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
