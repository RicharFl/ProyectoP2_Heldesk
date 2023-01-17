package com.ipn.Helpdesk.excepciones;

public class UsuarioNotFoundException extends Exception {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(){
	        super("El usuario con ese username no existe en la base de datos , vuelva a intentar !!");
	    }

	    public UsuarioNotFoundException(String mensaje){
	        super(mensaje);
	    }

}
