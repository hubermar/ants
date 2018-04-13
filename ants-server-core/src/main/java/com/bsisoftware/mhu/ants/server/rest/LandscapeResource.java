package com.bsisoftware.mhu.ants.server.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bsisoftware.mhu.ants.server.Engine;
import com.bsisoftware.mhu.ants.shared.api.ITerrain;

@Path(RestAPI.PATH_LANDSCAPE)
public class LandscapeResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ITerrain> getTerrains() {
		return Engine.INSTANCE.getLandscape().getTerrains();
	}
	
}
