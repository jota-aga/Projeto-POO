package negocio.entidade;

import java.time.DayOfWeek;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;





public class AgendaMedica {
	private Medico medico;
	private ArrayList<Consulta> agendaMedica;
	
	public AgendaMedica(Medico medico) {
		this.medico = medico;
		this.agendaMedica = gerarAgendaDeConsultas(
				this.medico.getInicioDeAtendimento(), 
				this.medico.getFimDeAtendimento(), 
				this.medico.getDiasDeAtendimento());
	}
	
	public AgendaMedica() {
		
	}

	//Gera uma agenda de 30 dias para o médico
	
	public ArrayList<Consulta> gerarAgendaDeConsultas(LocalTime inicio, LocalTime fim, ArrayList<DayOfWeek> diasDeAtendimento){
		int dias = 0;
		LocalDate dataHoje = LocalDate.now();
		LocalTime horario;
		ArrayList<Consulta> consultas = new ArrayList<>();
				
		while(dias != 30) {
			horario = inicio;
			if(diasDeAtendimento.contains(dataHoje.getDayOfWeek())){
				while(horario != fim) {
					Consulta c = new Consulta(horario, dataHoje);
					consultas.add(c);
					horario = horario.plusMinutes(30);
				}
			}
			dias++;
			dataHoje = dataHoje.plusDays(1);
		}
				
		return consultas;
	}

	public ArrayList<Consulta> getAgendaMedica() {
		return agendaMedica;
	}

	public void setAgendaMedica(ArrayList<Consulta> agendaMedica) {
		this.agendaMedica = agendaMedica;
	}
	
	
}
