package com.bsisoftware.mhu.ants.javafx.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.api.AntsAPI;
import com.bsisoftware.mhu.ants.shared.api.ConfigurationsDTO;
import com.bsisoftware.mhu.ants.shared.api.ErrorDTO;
import com.bsisoftware.mhu.ants.shared.api.LandscapeDTO;
import com.bsisoftware.mhu.ants.shared.exception.ExceptionUtil;
import com.bsisoftware.mhu.ants.shared.exception.AntsRemoteException;
import com.bsisoftware.mhu.ants.shared.util.UriUtil;

public class AntsClient implements AntsAPI {

	private static final Logger LOG = LoggerFactory.getLogger(AntsClient.class);

	private WebTarget target;

	public AntsClient(String baseUri, String user, String password) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(LoggingFeature.class);
		clientConfig.register(HttpAuthenticationFeature.basic(user, password));
		Client client = ClientBuilder.newClient(clientConfig);
		target = client.target(baseUri);
	}

	@Override
	public LandscapeDTO getLandscape() {
		Invocation invocation = target.
				path(UriUtil.create(PATH_LANDSCAPE)).
				request(MediaType.APPLICATION_JSON_TYPE).
				accept(MediaType.APPLICATION_JSON_TYPE).
				buildGet();
		return doRemoteCall(invocation, LandscapeDTO.class);
	}

	public ConfigurationsDTO getConfigs() {
		Invocation invocation = target.path(UriUtil.create(AntsAPI.PATH_CONFIGS))
				.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).buildGet();
		return doRemoteCall(invocation, ConfigurationsDTO.class);
	}

	private <T> T doRemoteCall(Invocation invocation, Class<T> clazz)
			throws AntsRemoteException {
		ClientResponse response = invocation.invoke(ClientResponse.class);
		switch (response.getStatusInfo().getFamily()) {
		case SUCCESSFUL:
			return response.readEntity(clazz);
		default:
			if (response.hasEntity()) {
				ErrorDTO error = response.readEntity(ErrorDTO.class);
				throw ExceptionUtil.remote(LOG, error.getCode(), error.getMessage());
			}
			throw ExceptionUtil.remote(LOG, response.getStatus(), response.getStatusInfo().getReasonPhrase());
		}
	}

}
