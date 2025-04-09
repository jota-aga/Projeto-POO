package negocio;

import java.util.ArrayList;

import negocio.entidade.Consulta;
import negocio.exceptions.PacienteJaExisteException;
import negocio.exceptions.PacienteNaoExisteException;
import negocio.repositorio.paciente.IRepositorioPaciente;
import negocio.entidade.Paciente;


public class NegocioPaciente{
    private final IRepositorioPaciente repositorio;

    public NegocioPaciente(IRepositorioPaciente repositorio) {
        this.repositorio = repositorio;
    }



    public void adicionar(Paciente paciente) throws PacienteJaExisteException   {
        boolean existe = repositorio.existe(paciente.getCpf());

        if(existe) {
            throw new PacienteJaExisteException();
        }else {
            repositorio.adicionar(paciente);
        }

    }

    public void remover(String cpf) throws PacienteNaoExisteException {
        Paciente paciente = repositorio.procurarPorCpf(cpf);

        if(paciente == null) {
            throw new PacienteNaoExisteException();
        } else {
            repositorio.remover(paciente);
        }
    }



    public Paciente findByCpf(String cpf) throws PacienteNaoExisteException  {

        Paciente paciente = repositorio.procurarPorCpf(cpf);

        if(paciente == null) {
            throw new PacienteNaoExisteException();
        } else {
            return paciente;
        }
    }



    public void editarPaciente(Paciente paciente) throws PacienteNaoExisteException {
        Paciente p = repositorio.consultar(paciente);

        if(p == null) {
            throw new PacienteNaoExisteException();
        } else {
            repositorio.atualizar(paciente);
        }
    }

    public void listarPacientes() {
        repositorio.listar();
    }

    public ArrayList<Consulta> listarConsultasDoPaciente(String cpf) throws PacienteNaoExisteException{
        Paciente paciente = repositorio.procurarPorCpf(cpf);

        if(paciente == null){
            throw new PacienteNaoExisteException();
        }

        return paciente.getConsultas();
    }
}

