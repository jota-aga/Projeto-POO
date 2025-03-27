package src.Entidades;

public class Agenda {

	private String horario;
	private String dias;
	private Medico medico;
	
	
	public Agenda(String horario, String dias, Medico medico) {
		this.medico = medico;
		this.horario = horario;
		this.dias = dias;
	}


	public String getHorario() {return horario;}


	public void setHorario(String horario) {this.horario = horario;}


	public String getDia() {return dias;}


	public void setDia(String dias) {this.dias = dias;}


	public Medico getMedico() {return medico;}


	public void setMedico(Medico medico) {this.medico = medico;}
	
	
	
	
}
