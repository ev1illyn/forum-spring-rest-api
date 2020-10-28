package br.com.alura.forum.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.domain.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);
	
}
