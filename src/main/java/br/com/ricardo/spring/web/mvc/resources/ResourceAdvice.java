package br.com.ricardo.spring.web.mvc.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.ricardo.spring.web.mvc.exception.JediNotFoundException;

@ControllerAdvice
public class ResourceAdvice {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(JediNotFoundException.class)
	public void notFound() {
		
	}
}
