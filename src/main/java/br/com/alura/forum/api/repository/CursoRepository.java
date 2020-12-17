package br.com.alura.forum.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.domain.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	/**
	 * retorna Curso com o nome especificado
	 * @param nomeCurso
	 * @return
	 */
	Curso findByNome(String nomeCurso);
	
}
