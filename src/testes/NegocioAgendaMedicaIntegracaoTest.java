package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.entidade.Consulta;
import negocio.entidade.Medico;
import negocio.entidade.Paciente;
import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.CrmApenasNumerosException;
import negocio.exceptions.HorarioJaReservadoException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;
import negocio.NegocioAgendaMedica;

public class NegocioAgendaMedicaIntegracaoTest {
	private Paciente paciente;
	private Paciente paciente2;
	private Medico medico;
	private NegocioAgendaMedica negocioAgendaM;
	private Consulta consulta;
	

	@BeforeEach
	void setUp() throws CpfApenasNumerosException, CpfTamanhoInvalidoException,
    TelefoneTamanhoInvalidoException, CrmApenasNumerosException {
		paciente = new Paciente("Maria", "12345678901", "maria@gmail.com", "81999999999", LocalDate.of(2000, 10, 10), "123");
		paciente2 = new Paciente("João", "12365498778", "joao@gmail.com", "87999999999", LocalDate.of(2004, 9, 10), "654321");
		
		medico = new Medico("Dr. João", "09876543210", "joao@gmail.com", "81999999999", LocalDate.of(1990, 3, 20), "Cardiovascular", "123456",
				new ArrayList<>(List.of(DayOfWeek.TUESDAY, DayOfWeek.SATURDAY)),
				LocalTime.of(8, 0), LocalTime.of(12, 0)
				);
		
		negocioAgendaM = new NegocioAgendaMedica();
		
		consulta = medico.getAgenda().getAgendaMedica().get(0);
	}

	@Test
	void deveAgendarContulaComSucesso() throws HorarioJaReservadoException{
		negocioAgendaM.agendarConsulta(consulta, paciente);
		System.out.println("consulta agendada");
		
		assertEquals(paciente, consulta.getPaciente());
		assertTrue(paciente.getConsultas().contains(consulta));		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void deveCancelarConsultaComSucesso() throws HorarioJaReservadoException{
		negocioAgendaM.agendarConsulta(consulta, paciente);
		System.out.println("consulta agendada");
		
		negocioAgendaM.cancelarConsulta(consulta, paciente);
		System.out.println("consulta cancelada");
		
		assertNull(consulta.getPaciente());
		assertFalse(paciente.getConsultas().equals(consulta));
	}
	
	@Test
	void consultaSemSucesso() throws HorarioJaReservadoException {
		try{
			negocioAgendaM.agendarConsulta(consulta, paciente);
			negocioAgendaM.agendarConsulta(consulta, paciente2);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//Mostra que o segundo paciente não tem nenhuma consulta
		assertEquals(true, paciente2.getConsultas().isEmpty());
		
		//Mostra que a consulta pertence ao primeiro paciente
		assertEquals(true, paciente.getConsultas().contains(consulta));
		
	}

}
