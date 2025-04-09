package dados;

import java.util.ArrayList;

import negocio.repositorio.Medico.IRepositorioMedico;

import negocio.entidade.Medico;

public class MedicoArrayList implements IRepositorioMedico {

    private ArrayList<Medico> medicos;


    public MedicoArrayList() {
        medicos = new ArrayList<>();
    }

    @Override
    public void adicionar(Medico medico) {
        medicos.add(medico);
    }

    @Override
    public void remover(Medico medico) {
        medicos.remove(medico);
    }

    public Medico consultar(Medico medico) {
        for(Medico m : medicos) {
            if(medico.equals(m)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Medico procurarPorCpf(String cpf) {
        for(Medico m : medicos) {
            if(m.getCpf().equals(cpf)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Medico procurarPorCrm(String crm) {
        for(Medico m : medicos) {
            if(m.getCrm().equals(crm)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Medico> procurarPorEspecialidade(String especialidade){
        ArrayList<Medico> especificos = new ArrayList<>();
        for(Medico m : medicos) {
            if(m.getEspecialidade().equals(especialidade)) {
                especificos.add(m);
            }
        }
        return especificos;
    }

    @Override
    public void atualizar(Medico medico) {
        int indice = medicos.indexOf(medico);
        if(indice != -1) {
            medicos.set(indice, medico);
        }
    }

    @Override
    public void listar() {
        for(Medico m : medicos) {
            System.out.println(m.getInformacoes());
        }
    }

    @Override
    public int quantidadeDeMedicos() {
        int quantidade = 0;
        for(Medico m : medicos) {
            quantidade++;
        }
        return quantidade;
    }

    @Override
    public boolean existe(String cpf) {
        for(Medico m : medicos) {
            if(m.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}

