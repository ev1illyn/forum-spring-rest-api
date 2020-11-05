package br.com.alura.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.alura.forum.api.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AutenticacaoService autenticacaoService;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	// configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/topicos").permitAll() // liberando acesso apenas às requisições do tipo GET
			.antMatchers(HttpMethod.GET, "/topicos/*").permitAll() // liberando acesso apenas às requisições do tipo GET/*
			.antMatchers(HttpMethod.POST, "/auth").permitAll() // liberando acesso apenas às requisições do tipo GET/*
			.antMatchers(HttpMethod.GET, "/actuator/**").permitAll() // liberando acesso ao monitorador
			.anyRequest().authenticated() // restrigindo acesso ao restante das requisições
			//.and().formLogin(); // redirecionando user para o form de login padrão
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // gerenciamento Stateless
			.and().addFilterBefore(new AutenticacaoViaTokerFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class); // filtrando a cada requisição para receber token
	}

	// configuracoes de recursos estaticos(js, css, img)
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
}
