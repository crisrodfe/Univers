package com.crisrodfe.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * The Class SpringBootApplication.
 */
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan({"com.crisrodfe"})//mapeará los módulos e inyectará al contexto las clases con anotaciones de services,repository,entidades,etc
@EnableJpaRepositories({"com.crisrodfe"})
@EntityScan({"com.crisrodfe"})
public class SpringBootApplication extends SpringBootServletInitializer
{
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.context.web.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app)
	{
		return app.sources(SpringBootApplication.class);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
}
