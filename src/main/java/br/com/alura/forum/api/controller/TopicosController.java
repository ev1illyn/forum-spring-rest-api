package br.com.alura.forum.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.api.model.TopicoDto;
import br.com.alura.forum.api.model.TopicoForm;
import br.com.alura.forum.api.repository.CursoRepository;
import br.com.alura.forum.domain.model.Topico;
import br.com.alura.forum.domain.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> listar(String nomeCurso) {

		List<Topico> topicos = nomeCurso == null ? topicoRepository.findAll() : topicoRepository.findByCurso_NomeContaining(nomeCurso);
		
		return TopicoDto.converter(topicos);

	}
	
	/* @RequestBody = parâmetros enviados no corpo da requisição são atribuídos ao parâmetro do método*/
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void cadastrar(@RequestBody TopicoForm topicoForm) {

		Topico topico = topicoForm.converter(cursoRepository);
		
		topicoRepository.save(topico);
		
	}

}
