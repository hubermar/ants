package com.bsisoftware.mhu.ants.javafx;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent> {
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
//		server.movePlayer(new Point(x, y));
	}

}
