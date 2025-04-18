package dados;

import java.util.ArrayList;
import negocio.entidade.Paciente;
import negocio.repositorio.paciente.IRepositorioPaciente;


public class PacienteArrayList implements IRepositorioPaciente {
    private ArrayList<Paciente> pacientes;


    public PacienteArrayList() {
        pacientes = new ArrayList<>();
    }

    @Override
    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    @Override
    public void remover(Paciente paciente) {
        pacientes.remove(paciente);
    }

    @Override
    public Paciente consultar(Paciente paciente) {
        for(Paciente p : pacientes) {
            if(paciente.equals(p)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public Paciente procurarPorCpf(String cpf) {
        for(Paciente p : pacientes) {
            if(p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Paciente paciente) {
        int indice = pacientes.indexOf(paciente);
        if(indice != -1) {
            pacientes.set(indice, paciente);
        }
    }

    @Override
    public void listar() {
        for(Paciente p : pacientes) {
            System.out.println(p.getInformacoes());
        }
    }

    @Override
    public int quantidadePacientes() {
        int quantidade = 0;
        for(Paciente p : pacientes) {
            quantidade++;
        }
        return quantidade;
    }
    @Override
    public boolean existe(String cpf) {
        for(Paciente p : pacientes) {
            if(p.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}

