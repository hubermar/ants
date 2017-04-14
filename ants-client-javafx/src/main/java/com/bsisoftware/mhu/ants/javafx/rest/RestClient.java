package com.bsisoftware.mhu.ants.javafx.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.api.RestAPI;
import com.bsisoftware.mhu.ants.shared.api.entity.ApiError;
import com.bsisoftware.mhu.ants.shared.api.entity.GameObject;
import com.bsisoftware.mhu.ants.shared.api.entity.Landscape;
import com.bsisoftware.mhu.ants.shared.exception.AntsRemoteException;
import com.bsisoftware.mhu.ants.shared.exception.ExceptionUtil;
import com.bsisoftware.mhu.ants.shared.server.IClient;
import com.bsisoftware.mhu.ants.shared.server.IServer;

public class RestClient implements IServer {

	private static final Logger LOG = LoggerFactory.getLogger(RestClient.class);

	private WebTarget target;

	public RestClient(String baseUri, String user, String password) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(LoggingFeature.class);
		clientConfig.register(HttpAuthenticationFeature.basic(user, password));
		Client client = ClientBuilder.newClient(clientConfig);
		target = client.target(baseUri);
	}

	public Landscape getLandscape() {
		Invocation invocation = target.
				path(RestAPI.PATH_LANDSCAPE).
				request(MediaType.APPLICATION_JSON_TYPE).
				accept(MediaType.APPLICATION_JSON_TYPE).
				buildGet();
		return doRemoteCall(invocation, Landscape.class);
	}

//	@Override
//	public ConfigurationsDTO getConfigurations() {
//		Invocation invocation = target.
//				path(UriUtil.create(RestAPI.PATH_CONFIGS)).
//				request(MediaType.APPLICATION_JSON_TYPE).
//				accept(MediaType.APPLICATION_JSON_TYPE).
//				buildGet();
//		return doRemoteCall(invocation, ConfigurationsDTO.class);
//	}

	private <T> T doRemoteCall(Invocation invocation, Class<T> clazz)
			throws AntsRemoteException {
		Response response = invocation.invoke(Response.class);
		switch (response.getStatusInfo().getFamily()) {
		case SUCCESSFUL:
			return response.readEntity(clazz);
		default:
			if (response.hasEntity()) {
				ApiError error = response.readEntity(ApiError.class);
				throw ExceptionUtil.remote(LOG, error.getCode(), error.getMessage());
			}
			throw ExceptionUtil.remote(LOG, response.getStatus(), response.getStatusInfo().getReasonPhrase());
		}
	}

	@Override
	public List<GameObject> getObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attach(IClient client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(IClient client) {
		// TODO Auto-generated method stub
		
	}

}
