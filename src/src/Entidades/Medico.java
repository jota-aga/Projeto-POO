package src.Entidades;

import java.util.Date;

public class Medico extends Pessoa {
	private String especialidade;
	private long crm;
	
	public Medico(String nome, String cpf, String email, Date dataNascimento, String especialidade, long crm) {
		super(nome, cpf, email, dataNascimento);
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public long getCrm() {
		return crm;
	}

	public void setCrm(long crm) {
		this.crm = crm;
	}

	@Override
	public String toString() {
		return String.format("Medico [especialidade=%s, crm=%s]", especialidade, crm);
	}

	

	
	
	
}
