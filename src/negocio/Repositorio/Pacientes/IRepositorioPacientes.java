package negocio.Repositorio.Pacientes;

import negocio.Entidades.Paciente;

public interface IRepositorioPacientes {
	
	void adicionar(Paciente paciente);
	
	void remover(Paciente paciente);
	
	void atualizar(Paciente paciente);
		
	Paciente consultar(Paciente paciente);
	
	Paciente procurarPorCpf(String cpf);
	
	void listar();
	
	boolean existe(String cpf);
}
