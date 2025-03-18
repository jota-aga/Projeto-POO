package src.Repositorio;

import java.util.ArrayList;

import src.Entidades.Medico;

public class RepositorioMedico {
	private ArrayList<Medico> medicos;
	
	public RepositorioMedico() {
		medicos = new ArrayList<>();
	}
	
	public void adicionarMedico(Medico m) {
		medicos.add(m);
	}
	
	public void removerMedico(Medico medico) {
		for(Medico m : medicos) {
			if(m.equals(medico)){
				medicos.remove(m);
			}
		}
	}
	
	public Medico procurarPorCpf(String cpf) {
		for(Medico m : medicos) {
			if(cpf.equals(m.getCpf())) {
				return m;
			}
		}
		return null;
	}
	
	public Medico procurarPorEspecialidade(String especialidade) {
		for(Medico m : medicos) {
			if(especialidade.equals(m.getEspecialidade())) {
				return m;
			}
		}
		return null;
	}
	
	public void listarMedicos() {
		for(Medico m : medicos) {
			System.out.println(m);
		}
	}
}
