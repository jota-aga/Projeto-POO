package fachada;

import java.time.DayOfWeek;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import negocio.entidade.Consulta;
import negocio.entidade.Medico;
import negocio.entidade.Paciente;
import negocio.exceptions.ConsultaNaoExisteException;
import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.CrmApenasNumerosException;

import negocio.exceptions.EspecialidadeNaoCadastradaException;

import negocio.exceptions.HorarioJaReservadoException;
import negocio.exceptions.MedicoJaExisteException;
import negocio.exceptions.MedicoNaoExisteException;
import negocio.exceptions.PacienteJaExisteException;
import negocio.exceptions.PacienteNaoExisteException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;

public class AssistenteFachada extends ClinicaFachada {

    public AssistenteFachada() {
        super();
    }


    @Override
    public void adicionarPaciente(String nome, String cpf, String email, String telefone, LocalDate dataDeNascimento,
                                  String cartaoMedico) throws CpfApenasNumerosException, CpfTamanhoInvalidoException,
            TelefoneTamanhoInvalidoException, PacienteJaExisteException {

        super.adicionarPaciente(nome, cpf, email, telefone, dataDeNascimento, cartaoMedico);
    }


    @Override
    public void removerPaciente(String cpf) throws PacienteNaoExisteException {

        super.removerPaciente(cpf);
    }


    @Override
    public void atualizarPaciente(String nome, String cpf, String email, String telefone, String cartaoMedico)
            throws PacienteNaoExisteException {

        super.atualizarPaciente(nome, cpf, email, telefone, cartaoMedico);
    }


    @Override
    public void adicionarMedico(String nome, String cpf, String email, String telefone, LocalDate dataDeNasciemnto,
                                String especialidade, String crm, ArrayList<DayOfWeek> diasDeAtendimento, LocalTime inicioDeAtendimento,
                                LocalTime fimDeAtendimento) throws CpfApenasNumerosException, CrmApenasNumerosException,
            CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException, MedicoJaExisteException {

        super.adicionarMedico(nome, cpf, email, telefone, dataDeNasciemnto, especialidade, crm, diasDeAtendimento,
                inicioDeAtendimento, fimDeAtendimento);
    }


    @Override
    public void removerMedico(String cpf) throws MedicoNaoExisteException {

        super.removerMedico(cpf);
    }


    @Override
    public void atualizarMedico(String cpf, String email, String telefone, String especialidade, String crm,
                                ArrayList<DayOfWeek> diasDeAtendimento, LocalTime inicioDeAtendimento, LocalTime fimDeAtendimento)
            throws MedicoNaoExisteException {

        super.atualizarMedico(cpf, email, telefone, especialidade, crm, diasDeAtendimento, inicioDeAtendimento,
                fimDeAtendimento);
    }


    @Override
    public void agendarConsulta(String crm, LocalDate data, LocalTime horario, String cpf)
            throws MedicoNaoExisteException, PacienteNaoExisteException, HorarioJaReservadoException, ConsultaNaoExisteException {

        super.agendarConsulta(crm, data, horario, cpf);
    }


    @Override
    public void cancelarConsulta(String id, String cpf) throws ConsultaNaoExisteException, PacienteNaoExisteException {

        super.cancelarConsulta(id, cpf);
    }

    public void listarPacientes() {
        negocioPaciente.listarPacientes();
    }

    public void listarMedicos() {
        negocioMedico.listarMedicos();
    }

    public void listarConsultasDoMedico(String cpf) throws MedicoNaoExisteException {
        Medico medico = negocioMedico.procurarPorCpf(cpf);
        ArrayList<Consulta> consultas = negocioAgenda.acessarAgendaDoMedico(medico);

        for(Consulta c : consultas) {
            System.out.println(c);
        }

    }

    public void listarMedicosPorEspecialidade(String especialidade) throws EspecialidadeNaoCadastradaException {
        ArrayList<Medico> medicos = negocioMedico.procurarPorEspecialidade(especialidade);

        for(Medico m : medicos) {
            System.out.println(m);
        }

    }

    public void procurarPacientePorCpf(String cpf) throws PacienteNaoExisteException {
        Paciente paciente = negocioPaciente.findByCpf(cpf);
        System.out.println(paciente);
    }


}

