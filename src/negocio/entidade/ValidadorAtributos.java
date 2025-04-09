package negocio.entidade;

import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.CrmApenasNumerosException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;


public class ValidadorAtributos {
	
	public static void validarCpf(String cpf) throws CpfApenasNumerosException, CpfTamanhoInvalidoException{
		if(cpf.length() != 11) {
			throw new CpfTamanhoInvalidoException();
		}
		
		try {
			Long.parseLong(cpf);
		} catch(NumberFormatException e) {
			throw new CpfApenasNumerosException();
		}
	}
	
	public static void validarCrm(String crm) throws CrmApenasNumerosException{	
		try {
			Long.parseLong(crm);
		} catch(NumberFormatException e) {
			throw new CrmApenasNumerosException();
		}
	}
	
	public static void validarTelefone(String telefone) throws TelefoneTamanhoInvalidoException{
		if(telefone.length() != 11) {
			throw new TelefoneTamanhoInvalidoException();
		}
	}
}
