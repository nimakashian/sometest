package swaggerjetty;



import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//org/objectweb/asm/ClassVisitor


public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Setup API resources
        ServletHolder apiServlet = context.addServlet(HelloServlet.class, "/api/*");
        apiServlet.setInitOrder(1);
        apiServlet.setInitParameter("com.sun.jersey.config.property.packages", "com.api.resources;io.swagger.jaxrs.json;io.swagger.jaxrs.listing");

        // Setup Swagger servlet
//        ServletHolder swaggerServlet = context.addServlet(DefaultJaxrsConfig.class, "/swagger-core");
//        swaggerServlet.setInitOrder(2);
//        swaggerServlet.setInitParameter("api.version", "1.0.0");

        // Setup Swagger-UI static resources
        String resourceBasePath = Main.class.getResource("/swaggerjetty/webapp").toExternalForm();
        context.setWelcomeFiles(new String[] {"index.html"});
        context.setResourceBase(resourceBasePath);
        context.addServlet(new ServletHolder(new DefaultServlet()), "/*");

        server.start();
        server.join();
    }



    static class HelloHandler extends AbstractHandler {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
                response.getWriter().println("<h1>Hello World</h1>");
            }
        }


    }


}
