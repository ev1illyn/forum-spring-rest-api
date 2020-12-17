package br.com.alura.forum.api.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.domain.model.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest // anotação do Spring específica para testar repositórios
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Test
	public void testFindByNameCourse() {
		String nomeCurso = "Spring Boot";
		Curso curso = repository.findByNome(nomeCurso);
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void testFindByNameCourseNotRegistered() {
		String nomeCurso = "Curso não cadastrado";
		Curso curso = repository.findByNome(nomeCurso);
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
	}

}
