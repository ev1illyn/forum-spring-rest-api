package br.com.alura.forum.domain.repository;

import org.springframework.stereotype.Repository;

import br.com.alura.forum.domain.model.Topico;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	// retorna o filtro do campo do relacionamento Curso - findByRelacionamento_ColunaContaining
	Page<Topico> findByCurso_NomeContaining(String nomeCurso, Pageable paginacao);
	
}
