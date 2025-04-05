package negocio.Exceptions;

public class MedicoJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MedicoJaExisteException() {
		super("Medico já existe no sistema.");
	}

}
