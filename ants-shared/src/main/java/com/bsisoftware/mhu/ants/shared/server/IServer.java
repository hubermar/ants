package com.bsisoftware.mhu.ants.shared.server;

import java.util.List;

import com.bsisoftware.mhu.ants.shared.api.entity.IGameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.ILandscape;

public interface IServer {

	ILandscape getLandscape();

	List<IGameObject> getObjects();

}