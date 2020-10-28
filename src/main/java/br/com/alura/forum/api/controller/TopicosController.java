package br.com.alura.forum.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.api.controller.dto.TopicoDto;
import br.com.alura.forum.domain.model.Topico;
import br.com.alura.forum.domain.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {

		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();

			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNomeContaining(nomeCurso);

			return TopicoDto.converter(topicos);
		}

	}

}
