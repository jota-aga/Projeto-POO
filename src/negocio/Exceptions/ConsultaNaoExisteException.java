package negocio.Exceptions;

public class ConsultaNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConsultaNaoExisteException() {
		super("Consulta não existe no sistema.");
	}

}
