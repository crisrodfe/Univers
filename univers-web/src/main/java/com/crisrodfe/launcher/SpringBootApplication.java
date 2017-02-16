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

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan({"com.crisrodfe"})//mapeará los módulos e inyectará al contexto las clases con anotaciones de services,repository,entidades,etc
@EnableJpaRepositories({"com.crisrodfe"})
@EntityScan({"com.crisrodfe"})
public class SpringBootApplication extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app)
	{
		return app.sources(SpringBootApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
}
