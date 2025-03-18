package src.Repositorio;

import java.util.ArrayList;
import src.Entidades.Paciente;


public class RepositorioPaciente {
	private ArrayList<Paciente> pacientes;
	
	public RepositorioPaciente() {
		this.pacientes = new ArrayList<>();
	}
	
	public void adicionarPaciente(Paciente p) {
		pacientes.add(p);
	}
	
	public void removerPaciente(Paciente p) {
		pacientes.remove(p);
	}
	
	public Paciente procurarPorCpf(String cpf) {
		for(Paciente p : pacientes) {
			if(p.getCpf().equals(cpf)) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Paciente> listarPacientes() {
		return pacientes;
	}
}
