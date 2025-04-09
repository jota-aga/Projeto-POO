package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.entidade.Consulta;
import negocio.entidade.Paciente;
import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;

class PacienteConsultaTest {

	private Paciente paciente;
	private Consulta consulta;

	
	
	@BeforeEach
	void setUp() throws   CpfApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException{
		paciente = new Paciente(
				"Maria", "12345678901", 
				"maria@gmail.com", "81999999999",
				LocalDate.of(2000, 12, 5), "123");

		
		consulta = new Consulta(LocalTime.of(10, 0), LocalDate.of(2025, 4, 7));
		consulta.Agendar(paciente);
		
	}

	
	@Test
	void deveAdicionarConsultaNaListaDoPaciente() {
		assertEquals(0, paciente.getConsultas().size());
	
		paciente.adicionarConsulta(consulta);
		System.out.println(paciente.getConsultas());
		
		assertEquals(1, paciente.getConsultas().size());
		assertTrue(paciente.getConsultas().contains(consulta));
		System.out.println(paciente.getConsultas());

	}
	
	@Test
	void deveRemoverConsultaDaListaDoPaciente() {
		paciente.adicionarConsulta(consulta);
		assertEquals(1, paciente.getConsultas().size());
		System.out.println(paciente.getConsultas());

		
		paciente.removerConsulta(consulta);
		assertEquals(0, paciente.getConsultas().size());
		assertFalse(paciente.getConsultas().contains(consulta));
		System.out.println(paciente.getConsultas());

	}

}
