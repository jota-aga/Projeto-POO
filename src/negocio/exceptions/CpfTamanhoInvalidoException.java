package negocio.exceptions;

public class CpfTamanhoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CpfTamanhoInvalidoException() {
		super("Tamanho do CPF inválido.");
	}
	
}
