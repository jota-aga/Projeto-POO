package negocio.exceptions;

public class CrmApenasNumerosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CrmApenasNumerosException() {
		super("CRM deve conter apenas números.");
	}

}
