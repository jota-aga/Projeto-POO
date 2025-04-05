package negocio.Exceptions;

public class EspecialidadeNaoCadastradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EspecialidadeNaoCadastradaException() {
		super("Especialidade não cadastrada no sistema");
	}
	
}
