package br.com.alura.forum.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
		
		return TopicoDto.converterLista(topicos);

	}
	
	/* @RequestBody = parâmetros enviados no corpo da requisição são atribuídos ao parâmetro do método
	 * @Valid = executa validacoes do Bean Validation no TopicoForm
	 * */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {

		Topico topico = topicoForm.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
