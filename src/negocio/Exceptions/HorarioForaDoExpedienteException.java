package negocio.Exceptions;

public class HorarioForaDoExpedienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HorarioForaDoExpedienteException() {
		super("O horário está fora do expediente do médico.");
	}

}
