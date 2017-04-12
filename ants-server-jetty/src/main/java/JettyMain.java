import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import com.bsisoftware.mhu.ants.server.api.ServerResources;
import com.bsisoftware.mhu.ants.shared.api.RestAPI;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

public class JettyMain {

	public static void main(String[] args) {
		
		ResourceConfig config = new ResourceConfig();
		config.packages(ServerResources.class.getPackage().getName());
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		int port = StaticConfiguration.getInt(StaticConfiguration.SERVER_PORT);
		Server server = new Server(port);
		ServletContextHandler context = new ServletContextHandler(server, RestAPI.CONTEXT + "/*");
		context.addServlet(servlet, RestAPI.API + "/*");

		try {
			server.start();
			System.out.println(server.dump());
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				server.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
			server.destroy();
		}
	}
}
