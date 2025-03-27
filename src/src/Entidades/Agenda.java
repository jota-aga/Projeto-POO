package src.Entidades;

public class Agenda {

	private String horario;
	private String dia;
	private Medico medico;
	
	
	public Agenda(String horario, String dia, Medico medico) {
		this.medico = medico;
		this.horario = horario;
		this.dia = dia;
	}


	public String getHorario() {return horario;}


	public void setHorario(String horario) {this.horario = horario;}


	public String getDia() {return dia;}


	public void setDia(String dia) {this.dia = dia;}


	public Medico getMedico() {return medico;}


	public void setMedico(Medico medico) {this.medico = medico;}
	
	
	
	
}
