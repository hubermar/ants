package com.bsisoftware.mhu.ants.shared.server;

import java.util.List;

import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.Landscape;

public interface IServer {

	Landscape getLandscape();
	List<GameObject> getObjects();

	void attach(IClient client);
	void detach(IClient client);

}