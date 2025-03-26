package src.Entidades;

import java.time.LocalDate;

import src.Exceptions.CpfApenasNumerosException;
import src.Exceptions.CpfTamanhoInvalidoException;
import src.Exceptions.CrmApenasNumerosException;

public class Medico extends Pessoa {
	private String especialidade;
	private String crm;
	
	public Medico(String nome, String cpf, String email, LocalDate dataNascimento, String especialidade, String crm) throws CpfApenasNumerosException, CrmApenasNumerosException, CpfTamanhoInvalidoException   {
		super(nome, cpf, email, dataNascimento);
		this.especialidade = especialidade;
		this.crm = crm;
		ValidadorAtributos.validarCrm(crm);
		
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public String toString() {
		return String.format("Medico [especialidade=%s, crm=%s]", especialidade, crm);
	}

}
