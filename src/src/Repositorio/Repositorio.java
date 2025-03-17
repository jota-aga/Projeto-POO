package src.Repositorio;

import java.util.ArrayList;
import src.Entidades.Paciente;


public class Repositorio {
	private ArrayList<Paciente> pacientes;
	
	public Repositorio() {
		this.pacientes = new ArrayList<>();
	}
	
	public void cadastrarPaciente(Paciente p) {
		pacientes.add(p);
	}
	
	public void removerPaciente(Paciente p) {
		pacientes.remove(p);
	}
	
	public Paciente findByCpf(String cpf) {
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
