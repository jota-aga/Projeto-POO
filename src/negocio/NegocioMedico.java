package negocio;



import negocio.exceptions.EspecialidadeNaoCadastradaException;
import negocio.exceptions.MedicoJaExisteException;
import negocio.exceptions.MedicoNaoExisteException;
import negocio.repositorio.Medico.IRepositorioMedico;

import java.util.ArrayList;


import negocio.entidade.Medico;




public class NegocioMedico {
    private final IRepositorioMedico repositorio;

    public NegocioMedico(IRepositorioMedico repositorio) {
        this.repositorio = repositorio;
    }


    public void adicionar(Medico medico) throws MedicoJaExisteException   {
        boolean existe = repositorio.existe(medico.getCpf());

        if(existe) {
            throw new MedicoJaExisteException();
        }else {
            repositorio.adicionar(medico);
        }

    }

    public void remover(String cpf) throws MedicoNaoExisteException {
        Medico medico = repositorio.procurarPorCpf(cpf);

        if(medico == null) {
            throw new MedicoNaoExisteException();
        } else {
            repositorio.remover(medico);
        }
    }


    public Medico procurarPorCpf(String cpf) throws MedicoNaoExisteException  {

        Medico medico = repositorio.procurarPorCpf(cpf);

        if(medico == null) {
            throw new MedicoNaoExisteException();
        } else {
            return medico;
        }
    }

    public Medico procurarPorCrm(String crm) throws MedicoNaoExisteException{
        Medico medico = repositorio.procurarPorCrm(crm);

        if(medico == null) {
            throw new MedicoNaoExisteException();
        } else {
            return medico;
        }

    }

    public ArrayList<Medico>procurarPorEspecialidade(String especialidade) throws EspecialidadeNaoCadastradaException  {
        ArrayList<Medico> especificos = repositorio.procurarPorEspecialidade(especialidade);
        if(especificos.isEmpty()) {
            throw new EspecialidadeNaoCadastradaException();
        } else {
            return especificos;
        }
    }


    public void editarMedico(Medico medico) throws MedicoNaoExisteException {
        Medico p = repositorio.consultar(medico);

        if(p == null) {
            throw new MedicoNaoExisteException();
        } else {
            repositorio.atualizar(medico);
        }
    }

    public void listarMedicos(){
        repositorio.listar();
    }
}

