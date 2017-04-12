package com.bsisoftware.mhu.ants.server.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bsisoftware.mhu.ants.shared.api.RestAPI;

@Path("")
public class LandscapeResource {

	private static final CacheControl NO_CACHING = new CacheControl();
	static {
		NO_CACHING.setNoCache(true);
		NO_CACHING.setNoStore(true);
		NO_CACHING.setMustRevalidate(true);		
	}
	
	@GET
	@Path(RestAPI.PATH_LANDSCAPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLandscape() {
		return Response.ok().
				cacheControl(NO_CACHING).
				entity(Engine.getLandscape()).build();
	}

}
