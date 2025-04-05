package negocio.Entidades;

import negocio.Exceptions.CpfApenasNumerosException;
import negocio.Exceptions.CpfTamanhoInvalidoException;
import negocio.Exceptions.CrmApenasNumerosException;
import negocio.Exceptions.TelefoneTamanhoInvalidoException;

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
		if(telefone.length() != 13) {
			throw new TelefoneTamanhoInvalidoException();
		}
	}
}
