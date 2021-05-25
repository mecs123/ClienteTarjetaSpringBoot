package com.pruebaTecnica.demo;

import com.pruebaTecnica.demo.RestAuth.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication
public class PruebaTecnicaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaBackendApplication.class, args);

	}

	/*
	La clase interna WebSecurityConfig, decorada con @EnableWebSecurity y @Configuration,
	nos permite especificar la configuración de acceso a los recursos publicados.
	En este caso se permiten todas las llamadas al controlador /user,
	pero el resto de las llamadas requieren autenticación.
	 */

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/v1/registro").permitAll()
					.anyRequest().authenticated();
		}
	}




}
