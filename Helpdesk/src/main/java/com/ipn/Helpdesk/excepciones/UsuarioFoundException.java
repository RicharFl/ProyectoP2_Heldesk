package com.ipn.Helpdesk.excepciones;

public class UsuarioFoundException extends Exception {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioFoundException(){
	        super("El usuario con ese username ya existe en la base de datos , vuelva a intentar !!");
	    }

	    public UsuarioFoundException(String mensaje){
	        super(mensaje);
	    }
}
