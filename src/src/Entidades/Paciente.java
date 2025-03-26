package src.Entidades;

import java.time.LocalDate;

import src.Exceptions.CpfApenasNumerosException;
import src.Exceptions.CpfTamanhoInvalidoException;
import src.Exceptions.TelefoneTamanhoInvalidoException;

public class Paciente extends Pessoa {
	private String cartaoMedico;
	
	
	public Paciente(String nome, String cpf, String email, String telefone, LocalDate dataNascimento, String cartaoMedico) throws CpfApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException{
		super(nome, cpf, email, telefone, dataNascimento);
		this.cartaoMedico = cartaoMedico;
	}

	public String getCartaoMedico() {
		return cartaoMedico;
	}

	public void setCartaoMedico(String cartaoMedico) {
		this.cartaoMedico = cartaoMedico;
	}
	
	@Override
	public String getInformacoes() {
		return "Nome: " + getNome() +
				", CPF: " + getCpf()+
				", E-mail: " + getEmail()+
				", Nascimento: " + getDataNascimento()+
				", CartaoMedico: " + getCartaoMedico();			
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		
		Paciente outro = (Paciente) obj;
		return this.getCpf().equals(outro.getCpf());
	}



	@Override
	public int hashCode() {
	    return getCpf().hashCode(); 
	}

}
