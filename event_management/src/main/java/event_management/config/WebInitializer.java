package event_management.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// In your project, you are using WebInitializer as the entry point, 
// which extends AbstractAnnotationConfigDispatcherServletInitializer. 
// This class initializes the DispatcherServlet without needing web.xml.
//
// @ AppConfig --> configures the MVC components, such as view resolvers and resource handlers.
// @ RootConfig--> handles services and repositories.
// @ WebInitializer--> maps the servlet and configures the root and servlet contexts.
//
// This setup is completely functional for your annotation-based Spring MVC configuration.

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class }; // Root application context config (Services, Repositories, etc.)
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AppConfig.class }; // Spring MVC config (Controllers, View resolvers, etc.)
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Map the DispatcherServlet to the root
    }
}

