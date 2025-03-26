package src.Entidades;

import src.Exceptions.CpfApenasNumerosException;
import src.Exceptions.CpfTamanhoInvalidoException;
import src.Exceptions.CrmApenasNumerosException;

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
}
