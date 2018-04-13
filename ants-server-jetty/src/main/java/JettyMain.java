import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import com.bsisoftware.mhu.ants.server.rest.RestAPI;
import com.bsisoftware.mhu.ants.shared.Application;
import com.bsisoftware.mhu.ants.shared.frontend.Frontend;
import com.bsisoftware.mhu.ants.shared.util.StaticConfiguration;

public class JettyMain {

	public static void main(String[] args) {
		

		int port = StaticConfiguration.getInt(StaticConfiguration.SERVER_PORT);
		Server server = new Server(port);
				
		// add handler for REST BASE
		String restContext = Application.CONTEXT + Application.VERSION + RestAPI.BASE;
		ServletContextHandler restHandler = new ServletContextHandler(server, restContext);
		ResourceConfig config = new ResourceConfig();
		config.packages(RestAPI.class.getPackage().getName());
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));
		restHandler.addServlet(servlet, "/*" /*restContext*/);

		// add handler for web pages
		String frontendContext = Application.CONTEXT + Application.VERSION + Frontend.BASE;
	    WebAppContext webHandler = new WebAppContext();
	    webHandler.setContextPath(frontendContext);
	    webHandler.setResourceBase("../ants-server-core/src/main/webapp" + Frontend.BASE + Application.VERSION);
	    webHandler.setWelcomeFiles(new String[]{ "index.html" });
	    
	    HandlerList handlers = new HandlerList();
	    handlers.setHandlers(new Handler[] { webHandler, restHandler });
	    server.setHandler(handlers);		
		
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
