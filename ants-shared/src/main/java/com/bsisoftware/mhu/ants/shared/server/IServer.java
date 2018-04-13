package com.bsisoftware.mhu.ants.shared.server;

import java.util.List;

import com.bsisoftware.mhu.ants.shared.api.IGameObject;
import com.bsisoftware.mhu.ants.shared.api.ILandscape;

public interface IServer {

	ILandscape getLandscape();

	List<IGameObject> getObjects();

}