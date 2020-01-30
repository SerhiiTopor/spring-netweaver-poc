package com.spring.poc.configuration;

import com.spring.poc.user_feature.domain.User;
import com.spring.poc.user_feature.user_managment.service.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/view/");
        bean.setSuffix(".jsp");

        return bean;
    }

    @Bean
    public RepositoryRestConfiguration RepositoryRestConfiguration() throws URISyntaxException {
        Map<Class<?>, Class<?>> domainTypes = new HashMap<>();
        domainTypes.put(User.class, UserRepository.class);
        return new RepositoryRestConfiguration()
                .setBaseUri(URI.create("/"))
                .setDomainTypeToRepositoryMappings(domainTypes);
    }
}
