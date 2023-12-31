package com.ti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;



@SpringBootApplication
@EnableJpaAuditing
public class TermPlanApplication extends SpringBootServletInitializer {
	
    @Autowired
    private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(TermPlanApplication.class, args);
	}
	
	
	@Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig(this::configure);
    }
	
    private void configure(RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));

    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TermPlanApplication.class);
    }
}

