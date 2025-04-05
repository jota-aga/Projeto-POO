package negocio.Negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import negocio.Entidades.AgendaMedica;
import negocio.Entidades.Consulta;
import negocio.Entidades.Medico;
import negocio.Entidades.Paciente;
import negocio.Exceptions.HorarioJaReservadoException;
import negocio.Exceptions.DiaForaDoExpedienteException;
import negocio.Exceptions.HorarioForaDoExpedienteException;
import negocio.Exceptions.HorarioJaReservadoException;

public class NegocioAgendaMedica {
	private AgendaMedica agendaMedica;
	
	public NegocioAgendaMedica() {}
	
	public Consulta procurarConsultaPorId(ArrayList<Consulta> consultas, String id) {
		for(Consulta consulta : consultas) {
			if(consulta.getId().equals(id)) {
				return consulta;
			}
		}
		return null;
	}
	
	public Consulta procurarConsultaPorParametros(ArrayList<Consulta> consultas, LocalDate data, LocalTime horario) 
			throws HorarioForaDoExpedienteException, DiaForaDoExpedienteException {
		agendaMedica.validarDia(data);
		agendaMedica.validarHorario(horario);
		
		for(Consulta consulta : consultas) {
			if(consulta.getHora().equals(horario) && consulta.getData().equals(data)) {
				return consulta;
			}
		}
		return null;
	}
	
	public void listarConsultasMedico(Medico medico) {
		ArrayList<Consulta> consultas = medico.getAgenda().getAgendaMedica();
		
		for(Consulta consulta : consultas) {
			System.out.println(consulta);
		}
	}
	
	public void listarConsultasDisponiveis(Medico medico) {
		ArrayList<Consulta> consultas = medico.getAgenda().getAgendaMedica();
		
		for(Consulta consulta : consultas) {
			if(consulta.getPaciente() == null) {
				System.out.println("Data: "+consulta.getData()+"/ Horário: "+consulta.getHora());
			}
		}
	}
	
	public void agendarConsulta(Consulta consulta, Paciente paciente) throws HorarioJaReservadoException  {
		if(consulta.getPaciente() == null) {
			consulta.Agendar(paciente);
			paciente.adicionarConsulta(consulta);
		} else {
			throw new HorarioJaReservadoException();
		}
	}
	
	public void cancelarConsulta(Consulta consulta, Paciente paciente)  {

		consulta.Cancelar();
		paciente.removerConsulta(consulta);
	}
}
