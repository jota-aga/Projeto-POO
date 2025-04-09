package negocio;

import java.time.LocalDate;



import java.time.LocalTime;
import java.util.ArrayList;

import negocio.entidade.AgendaMedica;
import negocio.entidade.Consulta;
import negocio.entidade.Medico;
import negocio.entidade.Paciente;
import negocio.exceptions.HorarioJaReservadoException;


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

    public Consulta procurarConsultaPorParametros(ArrayList<Consulta> consultas, LocalDate data, LocalTime horario) {
            

        for(Consulta consulta : consultas) {
            if(consulta.getHora().equals(horario) && consulta.getData().equals(data)) {
                return consulta;
            }
        }
        return null;
    }

    public ArrayList<Consulta> acessarAgendaDoMedico(Medico medico){
        return medico.getAgenda().getAgendaMedica();
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

