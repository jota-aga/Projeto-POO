package src.Exceptions;

public class CpfApenasNumerosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CpfApenasNumerosException() {
		super("O CPF deve conter apenas números.");
	}
	
}
