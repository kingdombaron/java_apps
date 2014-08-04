package com.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.spring.repositories")
@ComponentScan("com.spring")
public class PersistenceConfig {

	 
	@Value( "${db.driver_class}" ) private String PROPERTY_NAME_DATABASE_DRIVER;
	@Value( "${db.password}" ) private String PROPERTY_NAME_DATABASE_PASSWORD;
	@Value( "${db.url}" ) private String PROPERTY_NAME_DATABASE_URL;
	@Value( "${db.user}" ) private String PROPERTY_NAME_DATABASE_USERNAME;
    
	@Value( "${db.minPoolSize}" ) private int PROPERTY_NAME_MIN_POOL_SIZE;
	@Value( "${db.maxPoolSize}" ) private int PROPERTY_NAME_MAX_POOL_SIZE;
	@Value( "${db.acquireIncrement}" ) private int PROPERTY_NAME_ACQUIRE_INCREMENT;
	@Value( "${db.maxIdleTime}" ) private int PROPERTY_NAME_DATABASE_MAX_IDLE_TIME;
 
	@Value( "${hibernate.dialect}" ) private String PROPERTY_NAME_HIBERNATE_DIALECT;
	@Value( "${hibernate.show_sql}" ) private String PROPERTY_NAME_HIBERNATE_SHOW_SQL;
	@Value( "${hibernate.default_schema}" ) private String PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA;
	@Value( "${spring.packages_to_scan}" ) private String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN;
 
    @Bean
    public DataSource dataSource() {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();	
        try {
			dataSource.setDriverClass(PROPERTY_NAME_DATABASE_DRIVER);
	        dataSource.setJdbcUrl(PROPERTY_NAME_DATABASE_URL);
	        dataSource.setUser(PROPERTY_NAME_DATABASE_USERNAME);
	        dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
	        
	        dataSource.setMinPoolSize(PROPERTY_NAME_MIN_POOL_SIZE);
	        dataSource.setMaxPoolSize(PROPERTY_NAME_MAX_POOL_SIZE);
	        dataSource.setAcquireIncrement(PROPERTY_NAME_ACQUIRE_INCREMENT);
	        dataSource.setMaxIdleTime(PROPERTY_NAME_DATABASE_MAX_IDLE_TIME);

        } catch (IllegalStateException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return dataSource;
    }
 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(hibProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return entityManagerFactoryBean;
    }
 
    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,PROPERTY_NAME_HIBERNATE_DIALECT);
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,PROPERTY_NAME_HIBERNATE_SHOW_SQL);
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA);
        return properties;
    }
 
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
    	PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor = new PersistenceExceptionTranslationPostProcessor();
    	return persistenceExceptionTranslationPostProcessor;
    }
    
    @Bean
    public static PropertyPlaceholderConfigurer properties(){
      PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
      ClassPathResource[] resources =  new ClassPathResource[ ]
        { new ClassPathResource( "jdbc.properties" ) };
      ppc.setLocations( resources );
      ppc.setIgnoreUnresolvablePlaceholders( true );
      return ppc;
    }
	
	
}
