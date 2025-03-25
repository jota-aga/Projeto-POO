package src.Repositorio.Medico;


import java.util.ArrayList;

import src.Entidades.Medico;

public interface IRepositorioMedico {
	
	void adicionar(Medico medico);
	
	void remover(Medico medico);
	
	void atualizar(Medico medico);
		
	Medico consultar(Medico medico);
	
	Medico procurarPorCpf(String cpf);
	
	ArrayList<Medico> procurarPorEspecialidade(String especialidade);
	
	void listar();
	
	boolean existe(String cpf);
}
