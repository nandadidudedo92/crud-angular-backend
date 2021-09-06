package com.example.latihan.crud;


import com.example.latihan.crud.util.auth.JWTAuthorizationFilter;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CrudApplication {


	@Autowired
	private DataSource dataSource;

	@Bean
	public LiquibaseProperties liquibaseProperties() {
		return new LiquibaseProperties();
	}

	@Bean
	@DependsOn(value = "entityManagerFactory")
	public SpringLiquibase liquibase() {
		LiquibaseProperties liquibaseProperties = liquibaseProperties();
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog(liquibaseProperties.getChangeLog());
		liquibase.setContexts(liquibaseProperties.getContexts());
		liquibase.setDataSource(getDataSource(liquibaseProperties));
		liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
		liquibase.setDropFirst(liquibaseProperties.isDropFirst());
		liquibase.setShouldRun(true);
		liquibase.setLabels(liquibaseProperties.getLabels());
		liquibase.setChangeLogParameters(liquibaseProperties.getParameters());
		return liquibase;
	}

	private DataSource getDataSource(LiquibaseProperties liquibaseProperties) {
		if (liquibaseProperties.getUrl() == null) {
			return this.dataSource;
		}
		return DataSourceBuilder.create().url(liquibaseProperties.getUrl())
				.username(liquibaseProperties.getUser())
				.password(liquibaseProperties.getPassword()).build();
	}


	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/login","/register").permitAll()
					.antMatchers(HttpMethod.GET,"/h2-console").permitAll()
					.anyRequest().authenticated();
		}
	}

	@Bean
	public AuditorAware<String> auditorAware(){
		return new CustomAuditAware();
	}


}
