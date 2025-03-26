package src.Entidades;

import java.time.LocalDate;

import src.Exceptions.CpfApenasNumerosException;
import src.Exceptions.CpfTamanhoInvalidoException;

public class Paciente extends Pessoa {
	private String cartaoMedico;
	
	
	public Paciente(String nome, String cpf, String email, LocalDate dataNascimento, String cartaoMedico) throws CpfApenasNumerosException, CpfTamanhoInvalidoException{
		super(nome, cpf, email, dataNascimento);
		this.cartaoMedico = cartaoMedico;
	}

	public String getCartaoMedico() {
		return cartaoMedico;
	}

	public void setCartaoMedico(String cartaoMedico) {
		this.cartaoMedico = cartaoMedico;
	}

	@Override
	public String toString() {
		return String.format("Paciente [cartaoMedico=%s]", cartaoMedico);
	}

	

	
	
	
}
