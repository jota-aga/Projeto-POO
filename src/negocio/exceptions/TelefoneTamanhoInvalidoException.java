package negocio.exceptions;

public class TelefoneTamanhoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TelefoneTamanhoInvalidoException() {
		super("Número de telefone inválido");
	}

}
