package src.Negocio;



import src.Exceptions.EspecialidadeNaoCadastradaException;
import src.Exceptions.MedicoJaExisteException;
import src.Exceptions.MedicoNaoExisteException;
import src.Repositorio.Medico.IRepositorioMedico;

import java.util.ArrayList;

import src.Entidades.Medico;



public class NegocioMedico {
	private IRepositorioMedico repositorio;
	
	
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
	
	public ArrayList<Medico>procurarPorEspecialidade(String especialidade) throws EspecialidadeNaoCadastradaException  {
		ArrayList<Medico> especificos = repositorio.procurarPorEspecialidade(especialidade);
		if(especificos.size() == 0) {
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
}
