package br.com.alura.forum.repository;

import org.springframework.stereotype.Repository;

import br.com.alura.forum.model.Topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	/**
	 * retorna o filtro do campo do relacionamento Curso - findByRelacionamento_ColunaContaining
	 * @param nomeCurso
	 * @param paginacao
	 * @return
	 */
	Page<Topico> findByCurso_NomeContaining(String nomeCurso, Pageable paginacao);
	
}
