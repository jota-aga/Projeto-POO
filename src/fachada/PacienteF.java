package fachada;


import negocio.Entidades.Consulta;
import negocio.Entidades.Medico;
import negocio.Exceptions.*;
import negocio.Negocio.NegocioAgendaMedica;

import java.time.LocalDate;
import java.time.LocalTime;

public class PacienteF extends Clinica{
	private NegocioAgendaMedica negocioAgenda;

    public PacienteF(){
    	negocioAgenda = new NegocioAgendaMedica();
    }

    @Override
    public void agendarConsulta(String crm, LocalDate data, LocalTime horario, String cpf) throws MedicoNaoExisteException, PacienteNaoExisteException, DiaForaDoExpedienteException, HorarioForaDoExpedienteException, HorarioJaReservadoException, ConsultaNaoExisteException {
        super.agendarConsulta(crm, data, horario, cpf);
    }

    @Override
    public void cancelarConsulta(String id, String cpf) throws ConsultaNaoExisteException, PacienteNaoExisteException{
        super.cancelarConsulta(id, cpf);
    }

    @Override
    public void listarConsultasDoPaciente(String cpf) throws PacienteNaoExisteException {
        super.listarConsultasDoPaciente(cpf);
    }

    @Override
    public Medico procurarMedicoPorCrm(String crm) throws MedicoNaoExisteException {
        return super.procurarMedicoPorCrm(crm);
    }

    @Override
    public void procurarMedicoPorEspecialidade(String especialidade) throws EspecialidadeNaoCadastradaException {
        super.procurarMedicoPorEspecialidade(especialidade);
    }


    public void verificarCpf(String cpf) throws PacienteNaoExisteException {
        negocioPaciente.findByCpf(cpf);
    }
    
    public void listarConsultasDisponiveis(String crm) throws MedicoNaoExisteException {
    	Medico medico = procurarMedicoPorCrm(crm);
    	negocioAgenda.listarConsultasDisponiveis(medico);
    	
    }


}
