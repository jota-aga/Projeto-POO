package negocio.Exceptions;

public class DiaForaDoExpedienteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiaForaDoExpedienteException() {
		super("O dia está fora do expediente do médico.");
	}
}
