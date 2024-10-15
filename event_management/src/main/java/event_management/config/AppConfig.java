package event_management.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "event_management")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer{

	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        registry.viewResolver(resolver);
    }
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/css/**")
	                .addResourceLocations("/WEB-INF/css/");
	    }
	
	 @Bean
	    public DataSource dataSource() {
		 MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setURL("jdbc:mysql://localhost:3306/event_management");
	        dataSource.setUser("rath");
	        dataSource.setPassword("Ramadoss6*");
	        return dataSource;
	    }
	 
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan("event_management.model");
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }
	
	 private Properties hibernateProperties() {
	        Properties props = new Properties();
	        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	        props.setProperty("hibernate.hbm2ddl.auto", "update");
	        props.setProperty("hibernate.show_sql", "true");
	        return props;
	    }
	 
	 @Bean
	    public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager txManager = new HibernateTransactionManager();
	        txManager.setSessionFactory(sessionFactory().getObject());
	        return txManager;
	    }
}
