package api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bsisoftware.mhu.ants.shared.api.AntsAPI;
import com.bsisoftware.mhu.ants.shared.api.ConfigurationsDTO;


public class ConfigurationResource {

	private Map<String, String> configs = new HashMap<>();
	
	@GET
	@Path(AntsAPI.PATH_CONFIGS)
	@Produces(MediaType.APPLICATION_JSON)
	public ConfigurationsDTO getConfigurations() {
		return new ConfigurationsDTO();
	}
	
}
