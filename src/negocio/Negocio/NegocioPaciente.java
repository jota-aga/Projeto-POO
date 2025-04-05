package negocio.Negocio;

import negocio.Entidades.Consulta;
import negocio.Exceptions.CpfNaoCadastradoException;
import negocio.Exceptions.PacienteJaExisteException;
import negocio.Exceptions.PacienteNaoExisteException;
import negocio.Repositorio.Pacientes.IRepositorioPacientes;
import negocio.Entidades.Paciente;


public class NegocioPaciente{
	private final IRepositorioPacientes repositorio;
	
	public NegocioPaciente(IRepositorioPacientes repositorio) {
		this.repositorio = repositorio;
	}
	
	
	
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
	
	public void listarPacientes() {
		repositorio.listar();
	}

	public void listarConsultaDoPaciente(String cpf) throws PacienteNaoExisteException{
		Paciente paciente = repositorio.procurarPorCpf(cpf);

		if(cpf == null){
			throw new PacienteNaoExisteException();
		}

		if(paciente.getConsultas().isEmpty()){
			System.out.println("Esse paciente não tem nenhuma consulta marcada");
		}

		System.out.println("Consultas do paciente: " + paciente.getNome());
		for(Consulta consulta: paciente.getConsultas()){
			System.out.println(consulta);
		}
	}
}
