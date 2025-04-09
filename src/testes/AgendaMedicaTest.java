package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.entidade.AgendaMedica;
import negocio.entidade.Consulta;
import negocio.entidade.Medico;


class AgendaMedicaTest {
	private Medico medico;
	private AgendaMedica agendaMedica;

	@BeforeEach
	void setUp() throws Exception {
		ArrayList<DayOfWeek> diasDeAtendimento = new ArrayList<>(List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, 
				DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
	
		
		medico = new Medico("Dr. joao", "12345678901", "joao@gmail.com", "81999999999",
							LocalDate.of(1980, 1, 1), "Geral", "123456", diasDeAtendimento, LocalTime.of(8, 0), LocalTime.of(12,  0));
	
	
		agendaMedica = medico.getAgenda();
	}

	@Test
	void test() {
		ArrayList<Consulta> consultas = agendaMedica.getAgendaMedica();
		assertNotNull(consultas);
		assertFalse(consultas.isEmpty());
		
		
		for(Consulta c: consultas) {
			DayOfWeek dia = c.getData().getDayOfWeek();
			LocalTime hora = c.getHora();
			System.out.println(c);
			
			assertTrue(medico.getDiasDeAtendimento().contains(dia),
				"Dia da consulta fora do expediente: "+ dia);

			assertTrue(!hora.isBefore(medico.getInicioDeAtendimento())&&
					   !hora.isAfter(medico.getFimDeAtendimento().minusMinutes(30)),
					   "Horario da consulta fora do expediente: " + hora);
					
		}
	}

}
