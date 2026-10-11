package udSah.practice;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import udSah.practice.config.webConfig;

import java.io.File;

public class Main {
      public static void main(String[] args) throws LifecycleException {

         // boiler plate code

         Tomcat tomcat = new Tomcat();
         tomcat.setPort(8080);
         tomcat.getConnector();

         String contextPath ="";
         String baseDoc= new File("src/main/webApp").getAbsolutePath();

          Context  context = tomcat.addContext(contextPath,baseDoc);

          // ioc container app
         AnnotationConfigWebApplicationContext springContext =
                 new AnnotationConfigWebApplicationContext();
         springContext.register(webConfig.class);

         // dispatcher servlet

         DispatcherServlet dispatcherServlet =
                 new DispatcherServlet(springContext);


         Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);
         context.addServletMappingDecoded("/", "dispatcherServlet");

         tomcat.start();
         System.out.println("Tomcat server is started");

         tomcat.getServer().await();



     }
}
