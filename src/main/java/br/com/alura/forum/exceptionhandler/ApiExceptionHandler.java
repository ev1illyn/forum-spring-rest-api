package br.com.alura.forum.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.forum.exception.ErroDeFormularioDto;

//componente(interceptor) do spring para tratamentos de exceções
@RestControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> exceptionHandler(MethodArgumentNotValidException exception) {
	
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		
		List<FieldError> camposErro = exception.getBindingResult().getFieldErrors();
		camposErro.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erroDeFormulario = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erroDeFormulario);
		});
		
		return dto;
		
	}
	
}
