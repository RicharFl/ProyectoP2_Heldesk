package com.ipn.Helpdesk.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcerNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID= 1L;
	
	
	public ResourcerNotFoundExeption (String mensaje)
	{
		super (mensaje);
		
	}
}
