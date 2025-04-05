package negocio.Repositorio.Medico;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import negocio.Entidades.Consulta;
import negocio.Entidades.Medico;

public interface IRepositorioMedico {
	
	void adicionar(Medico medico);
	
	void remover(Medico medico);
	
	void atualizar(Medico medico);
		
	Medico consultar(Medico medico);
	
	Medico procurarPorCpf(String cpf);
	
	Medico procurarPorCrm(String crm);
	
	ArrayList<Medico> procurarPorEspecialidade(String especialidade);
	
	void listar();
	
	boolean existe(String cpf);
}
