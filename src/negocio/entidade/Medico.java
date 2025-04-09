package negocio.entidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalTime;

import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.CrmApenasNumerosException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;

public class Medico extends Pessoa {
	private String especialidade;
	private String crm;
	private ArrayList<DayOfWeek> diasDeAtendimento;
	private LocalTime inicioDeAtendimento;
	private LocalTime fimDeAtendimento;
	private AgendaMedica agenda;
	private static int contador = 0;
	
	public Medico(
				String nome, 
				String cpf, 
				String email, 
				String telefone,  
				LocalDate dataNascimento, 
				String especialidade, String crm, 
				ArrayList<DayOfWeek> diasDeAtendimento, 
				LocalTime inicioDeAtendimento, 
				LocalTime fimDeAtendimento) throws  CpfApenasNumerosException, CrmApenasNumerosException,
													CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException
													 {
		
		super(String.valueOf(++contador),nome, cpf, email, telefone, dataNascimento); 
		this.especialidade = especialidade;
		this.crm = crm;
		this.diasDeAtendimento = diasDeAtendimento;
		this.inicioDeAtendimento = inicioDeAtendimento;
		this.fimDeAtendimento = fimDeAtendimento;
		
		ValidadorAtributos.validarCrm(crm);
		
		this.agenda = new AgendaMedica(this);
		
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
	
	public ArrayList<DayOfWeek> getDiasDeAtendimento() {
		return diasDeAtendimento;
	}
	

	public void setDiasDeAtendimento(ArrayList<DayOfWeek> diasDeAtendimento) {
		this.diasDeAtendimento = diasDeAtendimento;
	}

	public LocalTime getInicioDeAtendimento() {
		return inicioDeAtendimento;
	}

	public void setInicioDeAtendimento(LocalTime inicioDeAtendimento) {
		this.inicioDeAtendimento = inicioDeAtendimento;
	}

	public LocalTime getFimDeAtendimento() {
		return fimDeAtendimento;
	}

	public void setFimDeAtendimento(LocalTime fimDeAtendimento) {
		this.fimDeAtendimento = fimDeAtendimento;
	}
	
	public AgendaMedica getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaMedica agenda) {
		this.agenda = agenda;
	}
	
	@Override
	public String getInformacoes() {
		return "Nome: " + getNome() +
				", Código: "+ getId()+
				", CPF: " + getCpf()+
				", E-mail: " + getEmail()+
				", Nascimento: " + getDataNascimento()+
				", Especialidade: " + getEspecialidade()+
				", CRM: " + getCrm();
	}
	

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		
		Medico outro = (Medico) obj;
		return this.getCpf().equals(outro.getCpf());
	}



	@Override
	public int hashCode() {
	    return getCpf().hashCode(); 
	}
	

}
