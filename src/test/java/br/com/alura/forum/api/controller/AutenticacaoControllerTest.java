package br.com.alura.forum.api.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * testa dados de autenticação incorretos
	 * @throws Exception
	 */
	@Test
	public void testIncorrectAuthData() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"teste_invalido@gmail.com\",\"senha\":\"123}\"";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}

}
