package negocio.repositorio.paciente;

import negocio.entidade.Paciente;

public interface IRepositorioPaciente {

    void adicionar(Paciente paciente);

    void remover(Paciente paciente);

    void atualizar(Paciente paciente);

    Paciente consultar(Paciente paciente);

    Paciente procurarPorCpf(String cpf);

    void listar();

    int quantidadePacientes();

    boolean existe(String cpf);
}
