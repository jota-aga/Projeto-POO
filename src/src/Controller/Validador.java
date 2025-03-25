package src.Controller;
import src.Exceptions.CrmApenasNumerosException;
import src.Exceptions.CpfApenasNumerosException;
import src.Exceptions.CpfTamanhoInvalidoException;

public class Validador {
	
	public void validarCpf(String cpf) throws CpfTamanhoInvalidoException, CpfApenasNumerosException  {
		if(cpf.length() != 11) {
			throw new CpfTamanhoInvalidoException();
		}
		
		try {
			Long.parseLong(cpf);
		} catch(NumberFormatException e){
			throw new CpfApenasNumerosException();
		}
	}
	
	public void validarCrm(String crm) throws CrmApenasNumerosException{
		try {
			Long.parseLong(crm);
		} catch(NumberFormatException e) {
			throw new CrmApenasNumerosException();
		}
	}
}
