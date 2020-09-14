package com.isdma.workshopmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.isdma.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice //diz que classe é responsavel por tratar possiveis erros nas requisições
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)//padrao do framework tem de se colocar para dar
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado!", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
				
				//agora nao metemos ReponseEntity.ok porque vamos querer personalizar as mensagem de excepção aos request nao concretizados
	}
}
