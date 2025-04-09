package negocio.exceptions;

public class PacienteJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PacienteJaExisteException() {
		super("Esse paciente já existe no sistema.");
	}

}
