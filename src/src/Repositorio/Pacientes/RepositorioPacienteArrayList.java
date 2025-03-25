package src.Repositorio.Pacientes;

import java.util.ArrayList;
import src.Entidades.Paciente;


public class RepositorioPacienteArrayList implements IRepositorioPacientes {
	private ArrayList<Paciente> pacientes;
	
	
	public RepositorioPacienteArrayList() {
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
	
	public Paciente consultar(Paciente paciente) {
		for(Paciente p : pacientes) {
			if(paciente.equals(p)) {
				return p;
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
			System.out.println(p);
		}
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
