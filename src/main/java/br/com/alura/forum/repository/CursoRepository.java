package br.com.alura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.forum.model.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

	/**
	 * retorna Curso com o nome especificado
	 * @param nomeCurso
	 * @return
	 */
	Curso findByNome(String nomeCurso);
	
}
