package negocio.entidade;

import java.time.LocalDate;
import java.util.ArrayList;

import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;


public class Paciente extends Pessoa {
	private String cartaoMedico;
	private ArrayList<Consulta> consultas;
	private static int contador = 0;
	
	
	public Paciente(String nome, String cpf, String email, String telefone, LocalDate dataNascimento, String cartaoMedico)
					throws CpfApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException{

		super(String.valueOf(++contador),nome, cpf, email, telefone, dataNascimento);
		this.cartaoMedico = cartaoMedico;
		this.consultas = new ArrayList<>();
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
				", Código: " + getId()+
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

	public void adicionarConsulta(Consulta consulta){
		consultas.add(consulta);
	}

	public void removerConsulta(Consulta consulta){
		consultas.remove(consulta);
	}

	public ArrayList<Consulta> getConsultas(){
		return new ArrayList<>(consultas);
	}



	@Override
	public int hashCode() {
	    return getCpf().hashCode(); 
	}
	
	@Override
	public String toString() {
		return getInformacoes();
	}

}
