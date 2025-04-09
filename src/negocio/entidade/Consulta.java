package negocio.entidade;

import java.time.LocalDate;
import java.time.LocalTime;


public class Consulta {
	private static int contador = 0;
	private Paciente paciente;
	private LocalTime hora;
	private LocalDate data;
	private String id;
	
	public Consulta(LocalTime hora, LocalDate data){
		this.id = String.valueOf(++contador);
		this.hora = hora;
		this.data = data;
	}

	public void Cancelar() {
		this.paciente = null;
	}

	public void Agendar(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Consulta [paciente=%s, hora=%s, data=%s]", paciente, hora, data);
	}
	
	
	
	
}
