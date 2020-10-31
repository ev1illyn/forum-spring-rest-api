package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class ConfiguracaoSegurancao extends WebSecurityConfigurerAdapter{
	
	// configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	}

	// configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/topicos").permitAll() // liberando acesso apenas às requisições do tipo GET
			.antMatchers(HttpMethod.GET, "/topicos/*").permitAll() // liberando acesso apenas às requisições do tipo GET/*
			.anyRequest().authenticated() // restrigindo acesso ao restante das requisições
			.and().formLogin(); // redirecionando user para o form de login
	}

	// configuracoes de recursos estaticos(js, css, img)
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
	
}
