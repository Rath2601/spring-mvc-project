package event_management.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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

