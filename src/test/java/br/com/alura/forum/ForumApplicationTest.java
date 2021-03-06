package br.com.alura.forum;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // Spring inicializa o servidor e carrega os beans da aplicação durante a execução dos testes automatizados.
@ActiveProfiles("test")
class ForumApplicationTest {

	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

}
