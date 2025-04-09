package negocio.exceptions;

public class MedicoNaoExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MedicoNaoExisteException() {
		super("Medico já existe no sistema.");
	}
}
