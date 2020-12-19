package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class DevConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	// configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll() // liberando acesso à todas as requisições no Profile DEV
		.and().csrf().disable();
	}
	
	/*
	 * @Override
	 * 
	 * @Bean protected AuthenticationManager authenticationManager() throws
	 * Exception { return super.authenticationManager(); }
	 */
}
