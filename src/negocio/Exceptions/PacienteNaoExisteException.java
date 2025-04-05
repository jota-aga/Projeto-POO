package negocio.Exceptions;

public class PacienteNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PacienteNaoExisteException() {
		super("O paciente nãoe existe no sistema.");
	}

}
