package br.com.alura.forum.api.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.api.repository.CursoRepository;
import br.com.alura.forum.domain.model.Curso;
import br.com.alura.forum.domain.model.Topico;

public class TopicoForm {

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 200)
	private String titulo;

	@NotNull
	@NotEmpty
	@Length(min = 10, max = 255)
	private String mensagem;

	@NotNull
	@NotEmpty
	@Length(max = 200)
	private String nomeCurso; // quando a requisição chegar com o nome do curso, será preciso buscar o curso pelo nome
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);		
	}
	
}