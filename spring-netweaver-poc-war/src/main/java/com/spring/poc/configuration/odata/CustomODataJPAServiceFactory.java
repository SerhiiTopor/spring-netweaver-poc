package com.spring.poc.configuration.odata;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class CustomODataJPAServiceFactory extends ODataJPAServiceFactory {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CustomODataJPAServiceFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
        ODataJPAContext oDataJPAContext = getODataJPAContext();

        oDataJPAContext.setEntityManagerFactory(entityManagerFactory);
        oDataJPAContext.setPersistenceUnitName("persistenceUnit");
        oDataJPAContext.setDefaultNaming(true);

        this.setDetailErrors(true);

        return oDataJPAContext;
    }
}
