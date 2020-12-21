package br.com.alura.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication/*(exclude={DataSourceAutoConfiguration.class})*/
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackages = {"br.com.alura.forum"})
@EnableCaching
@EnableSwagger2
public class ForumApplication{

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
	
}
