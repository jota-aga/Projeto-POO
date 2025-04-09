package negocio.exceptions;

public class HorarioJaReservadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HorarioJaReservadoException() {
		super("Esse .orário já está reservado por outra pessoa.");
	}
	
}
