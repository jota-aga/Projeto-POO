package fachada;

import java.time.DayOfWeek;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import negocio.entidade.AgendaMedica;
import negocio.entidade.Consulta;
import negocio.entidade.Medico;
import negocio.entidade.Paciente;
import negocio.exceptions.*;
import negocio.NegocioAgendaMedica;
import negocio.NegocioMedico;
import negocio.NegocioPaciente;
import dados.MedicoArrayList;
import dados.PacienteArrayList;

public class ClinicaFachada {
    protected static final NegocioPaciente negocioPaciente = new NegocioPaciente(new PacienteArrayList());
    protected static final NegocioMedico negocioMedico = new NegocioMedico (new MedicoArrayList());
    protected static final NegocioAgendaMedica negocioAgenda  = new NegocioAgendaMedica();


    public ClinicaFachada() {}



    public void adicionarPaciente(
            String nome,
            String cpf,
            String email,
            String telefone,
            LocalDate dataDeNascimento,
            String cartaoMedico) throws CpfApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException, PacienteJaExisteException {

        Paciente paciente = new Paciente( nome,  cpf,  email,  telefone,  dataDeNascimento,  cartaoMedico);
        negocioPaciente.adicionar(paciente);
    }


    public void removerPaciente(String cpf) throws PacienteNaoExisteException {
        negocioPaciente.remover(cpf);
    }


    public void atualizarPaciente(
            String nome,
            String cpf,
            String email,
            String telefone,
            String cartaoMedico) throws PacienteNaoExisteException {
        Paciente paciente = negocioPaciente.findByCpf(cpf);

        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setTelefone(telefone);
        paciente.setCartaoMedico(cartaoMedico);
    }

    public void adicionarMedico(
            String nome,
            String cpf,
            String email,
            String telefone,
            LocalDate dataDeNasciemnto,
            String especialidade,
            String crm, ArrayList<DayOfWeek> diasDeAtendimento,
            LocalTime inicioDeAtendimento,
            LocalTime fimDeAtendimento) throws CpfApenasNumerosException, CrmApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException, MedicoJaExisteException {

        Medico medico = new Medico( nome,  cpf,  email,  telefone,  dataDeNasciemnto,
                especialidade,  crm,  diasDeAtendimento,  inicioDeAtendimento,  fimDeAtendimento);

        negocioMedico.adicionar(medico);
    }


    public void removerMedico(String cpf) throws MedicoNaoExisteException {
        negocioMedico.remover(cpf);
    }


    public void atualizarMedico(String cpf, String email, String telefone, String especialidade,
                                String crm, ArrayList<DayOfWeek> diasDeAtendimento, LocalTime inicioDeAtendimento,
                                LocalTime fimDeAtendimento) throws MedicoNaoExisteException {

        Medico medico = negocioMedico.procurarPorCpf(cpf);
        medico.setEmail(email);
        medico.setTelefone(telefone);
        medico.setEspecialidade(especialidade);
        medico.setCrm(crm);
        medico.setDiasDeAtendimento(diasDeAtendimento);
        medico.setInicioDeAtendimento(inicioDeAtendimento);
        medico.setFimDeAtendimento(fimDeAtendimento);

        medico.setAgenda(new AgendaMedica(medico));
    }


    public void agendarConsulta(String crm, LocalDate data, LocalTime horario, String cpf)
            throws MedicoNaoExisteException, PacienteNaoExisteException,  HorarioJaReservadoException, ConsultaNaoExisteException {

        Paciente paciente = negocioPaciente.findByCpf(cpf);

        Medico medico = negocioMedico.procurarPorCrm(crm);
        ArrayList<Consulta> consultas = medico.getAgenda().getAgendaMedica();

        Consulta consulta = negocioAgenda.procurarConsultaPorParametros(consultas, data, horario);

        if(consulta == null) {
            throw new ConsultaNaoExisteException();
        }

        negocioAgenda.agendarConsulta(consulta, paciente);
    }


    public void cancelarConsulta(String id, String cpf)
            throws ConsultaNaoExisteException, PacienteNaoExisteException{

        Consulta consulta = null;
        Paciente paciente = negocioPaciente.findByCpf(cpf);
        ArrayList<Consulta> consultasDoPaciente = paciente.getConsultas();

        for(Consulta c : consultasDoPaciente) {
            if(c.getId().equals(id)) {
                consulta = c;
            }
        }

        if(consulta == null) {
            throw new ConsultaNaoExisteException();
        }else {
            negocioAgenda.cancelarConsulta(consulta, paciente);
        }
    }

    public void listar() {
        negocioPaciente.listarPacientes();
    }



    public ArrayList<Consulta> listarConsultasDoPaciente(String cpf) throws PacienteNaoExisteException {
        return negocioPaciente.listarConsultasDoPaciente(cpf);
    }

}

