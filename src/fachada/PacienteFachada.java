package fachada;



import negocio.entidade.Consulta;

import negocio.entidade.Medico;
import negocio.exceptions.*;
import negocio.NegocioAgendaMedica;
import negocio.NegocioMedico;
import negocio.NegocioPaciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PacienteFachada extends ClinicaFachada{

    public PacienteFachada(){
        super();
    }

    @Override
    public void agendarConsulta(String crm, LocalDate data, LocalTime horario, String cpf) throws MedicoNaoExisteException, PacienteNaoExisteException,  HorarioJaReservadoException, ConsultaNaoExisteException {
        super.agendarConsulta(crm, data, horario, cpf);
    }

    @Override
    public void cancelarConsulta(String id, String cpf) throws ConsultaNaoExisteException, PacienteNaoExisteException{
        super.cancelarConsulta(id, cpf);
    }

    public void verificarCpf(String cpf) throws PacienteNaoExisteException {
        negocioPaciente.findByCpf(cpf);
    }

    public void listarConsultasDisponiveis(String crm) throws MedicoNaoExisteException {
        Medico medico = negocioMedico.procurarPorCrm(crm);
        ArrayList<Consulta> consultas = negocioAgenda.acessarAgendaDoMedico(medico);

        for(Consulta c : consultas) {
            if(c.getPaciente() == null) {
                System.out.println("Data: "+c.getData()+"/ Horário: "+c.getHora());
            }
        }

    }


    public void listarConsultasDoPacientee(String cpf) throws PacienteNaoExisteException {
        ArrayList<Consulta> consultas = negocioPaciente.listarConsultasDoPaciente(cpf);

        for(Consulta c : consultas) {
            System.out.println(c);
        }

    }


}

