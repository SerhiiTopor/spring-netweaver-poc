package com.spring.poc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.spring.poc")
@PropertySource("classpath:/hibernate.properties")
public class DataConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:h2:~/test");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("com.spring.poc");
        entityManagerFactoryBean.setPersistenceUnitName("persistenceUnit");
        entityManagerFactoryBean.setJpaProperties(jpaProperties());

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactoryBean;
    }

    // ### EclipseLink EntityManager ###
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        vendorAdapter.setShowSql(false);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.spring.poc");
//        factory.setDataSource(dataSource);
//        factory.setJpaProperties(jpaProperties());
//        factory.setPersistenceUnitName("persistenceUnit");
//        return factory;
//    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    // ### EclipseLink Properties ###
//    private Properties jpaProperties() {
//        Properties jpaProperties = new Properties();
//        jpaProperties.put(PersistenceUnitProperties.CACHE_SHARED_DEFAULT, "false");
//        jpaProperties.put(PersistenceUnitProperties.SCHEMA_GENERATION_DATABASE_ACTION, "drop-and-create");
//        jpaProperties.put(PersistenceUnitProperties.SCHEMA_GENERATION_DROP_AND_CREATE_ACTION, "/sql-scripts/create.sql");
//        jpaProperties.put(PersistenceUnitProperties.SCHEMA_GENERATION_SQL_LOAD_SCRIPT_SOURCE, "/sql-scripts/insert.sql");
//        jpaProperties.put(PersistenceUnitProperties.DDL_GENERATION, "create-or-extend-tables");
//        jpaProperties.put(PersistenceUnitProperties.DDL_GENERATION_MODE, "database");
//        jpaProperties.put(PersistenceUnitProperties.WEAVING, "false");
//        return jpaProperties;
//    }

    final Properties jpaProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
         /*
            This fallback to classic query translator fixing issue to run Hibernate on Netweaver, Weblogic
            and other application servers, root cause of this problem is in class path of application servers
            that provides not compatible version of syntax lexical parser or not provides any all
            Hibernate is stick to concrete version of such parser as "antlr".
            ### To remove this workaround - compatible versions of Hibernate and "antlr" should be picked up. ###
          */
        hibernateProperties.setProperty("hibernate.query.factory_class", env.getProperty("hibernate.query.factory_class"));
        return hibernateProperties;
    }
}
