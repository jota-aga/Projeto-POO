package negocio.repositorio.Medico;

import java.util.ArrayList;

import negocio.entidade.Medico;

public interface IRepositorioMedico {

    void adicionar(Medico medico);

    void remover(Medico medico);

    void atualizar(Medico medico);

    Medico consultar(Medico medico);

    Medico procurarPorCpf(String cpf);

    Medico procurarPorCrm(String crm);

    ArrayList<Medico> procurarPorEspecialidade(String especialidade);

    void listar();

    int quantidadeDeMedicos();

    boolean existe(String cpf);
}
