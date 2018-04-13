package com.bsisoftware.mhu.ants.server;

import com.bsisoftware.mhu.ants.shared.api.IGameObject;

public interface ICollisionHandler {

	void handleCollisionWith(IGameObject o);
	
}
