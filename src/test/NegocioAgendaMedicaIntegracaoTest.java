package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.Entidades.Consulta;
import negocio.Entidades.Medico;
import negocio.Entidades.Paciente;
import negocio.Exceptions.CpfApenasNumerosException;
import negocio.Exceptions.CpfTamanhoInvalidoException;
import negocio.Exceptions.CrmApenasNumerosException;
import negocio.Exceptions.HorarioJaReservadoException;
import negocio.Exceptions.TelefoneTamanhoInvalidoException;
import negocio.Negocio.NegocioAgendaMedica;

public class NegocioAgendaMedicaIntegracaoTest {
	private Paciente paciente;
	private Medico medico;
	private NegocioAgendaMedica negocioAgendaM;
	private Consulta consulta;
	

	@BeforeEach
	void setUp() throws CpfApenasNumerosException, CpfTamanhoInvalidoException,
    TelefoneTamanhoInvalidoException, CrmApenasNumerosException {
		paciente = new Paciente("Maria", "12345678901", "maria@gmail.com", "819999999999", LocalDate.of(2000, 10, 10), "123");
		
		medico = new Medico("Dr. João", "098765432109", "joao@gmail.com", "81999999999", LocalDate.of(1990, 3, 20), "Cardiovascular", "123456",
				new ArrayList<>(List.of(DayOfWeek.TUESDAY, DayOfWeek.SATURDAY)),
				LocalTime.of(8, 0), LocalTime.of(12, 0)
				);
		
		negocioAgendaM = new NegocioAgendaMedica();
		
		consulta = medico.getAgenda().getAgendaMedica().get(0);
	}

	@Test
	void deveAgendarContulaComSucesso() throws HorarioJaReservadoException{
		negocioAgendaM.agendarConsulta(consulta, paciente);
		
		
		assertEquals(paciente, consulta.getPaciente());
		assertTrue(paciente.getConsultas().contains(consulta));		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void deveCancelarConsultaComSucesso() throws HorarioJaReservadoException{
		negocioAgendaM.agendarConsulta(consulta, paciente);
		
		negocioAgendaM.cancelarConsulta(consulta, paciente);
		
		assertNull(consulta.getPaciente());
		assertFalse(paciente.getConsultas().equals(consulta));
	}

}
