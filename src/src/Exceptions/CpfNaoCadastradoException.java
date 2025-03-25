package src.Exceptions;

public class CpfNaoCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CpfNaoCadastradoException() {
		super("O CPF informado não está cadastrado no sistema.");
	}

}
