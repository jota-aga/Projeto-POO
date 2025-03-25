package src.Negocio;

import src.Exceptions.PacienteJaExisteException;
import src.Exceptions.PacienteNaoExisteException;
import src.Repositorio.Pacientes.IRepositorioPacientes;
import src.Entidades.Paciente;


public class NegocioPaciente{
	private IRepositorioPacientes repositorio;
	
	
	
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
}
