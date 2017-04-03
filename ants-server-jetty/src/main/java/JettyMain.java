import java.net.InetSocketAddress;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.glassfish.jersey.server.ResourceConfig;

import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

public class JettyMain {

	public static void main(String[] args) {
		ResourceConfig config = new ResourceConfig();
		config.packages("jettyjerseytutorial");
//		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		int port = StaticConfiguration.getInt(StaticConfiguration.SERVER_PORT);
		Server server = new Server(port);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
	//	context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			server.destroy();
		}
	}
}
