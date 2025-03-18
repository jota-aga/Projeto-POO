package src.Entidades;

import java.time.LocalDate;

public class Paciente extends Pessoa {
	private String cartaoMedico;
	
	public Paciente(String nome, String cpf, String email, LocalDate dataNascimento, String cartaoMedico) {
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
		return "Paciente [cartaoMedico=" + cartaoMedico + "]";
	}
	
	
}
