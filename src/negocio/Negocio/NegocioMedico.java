package negocio.Negocio;



import negocio.Exceptions.DiaForaDoExpedienteException;
import negocio.Exceptions.EspecialidadeNaoCadastradaException;
import negocio.Exceptions.HorarioForaDoExpedienteException;
import negocio.Exceptions.HorarioJaReservadoException;
import negocio.Exceptions.MedicoJaExisteException;
import negocio.Exceptions.MedicoNaoExisteException;
import negocio.Repositorio.Medico.IRepositorioMedico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import negocio.Entidades.Consulta;
import negocio.Entidades.Medico;
import negocio.Entidades.Paciente;



public class NegocioMedico {
	private final IRepositorioMedico repositorio;
	
	public NegocioMedico(IRepositorioMedico repositorio) {
		this.repositorio = repositorio;
	}
	
	
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
	
	public Medico procurarPorCrm(String crm) throws MedicoNaoExisteException{
		Medico medico = repositorio.procurarPorCrm(crm);
		
		if(medico == null) {
			throw new MedicoNaoExisteException();
		} else {
			return medico;
		}
	
	}
	
	public ArrayList<Medico>procurarPorEspecialidade(String especialidade) throws EspecialidadeNaoCadastradaException  {
		ArrayList<Medico> especificos = repositorio.procurarPorEspecialidade(especialidade);
		if(especificos.isEmpty()) {
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
	
	public Consulta procurarConsultaPorId(String id, String crm) {
		Medico medico = repositorio.procurarPorCrm(crm);
		
		for(Consulta c : medico.getAgenda().getAgendaMedica()) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	public Consulta procurarConsulta(String crm, LocalDate data, LocalTime horario) throws HorarioForaDoExpedienteException, DiaForaDoExpedienteException {
		Medico medico = repositorio.procurarPorCrm(crm);
		
		medico.getAgenda().validarHorario(horario);
		medico.getAgenda().validarDia(data);
		
		for(Consulta c : medico.getAgenda().getAgendaMedica()) {
			if(c.getData().equals(data) && c.getHora().equals(horario)) {
				return c;
			}
		}
		return null;
	}
	
	public void listarConsultas(String cpf) throws MedicoNaoExisteException{
		Medico medico = repositorio.procurarPorCpf(cpf);

		for(Consulta c : medico.getAgenda().getAgendaMedica()) {
			System.out.println(c);
		}
	}
	
	public void agendarConsulta(Consulta consulta, Paciente paciente) throws HorarioJaReservadoException  {
		if(consulta.getPaciente() == null) {
			consulta.Agendar(paciente);
			paciente.adicionarConsulta(consulta);
		} else {
			throw new HorarioJaReservadoException();
		}
	}
	
	public void cancelarConsulta(Consulta consulta, Paciente paciente)  {

		consulta.Cancelar();
		paciente.removerConsulta(consulta);
	}

	public void listarMedicos(){
		repositorio.listar();
	}
}
