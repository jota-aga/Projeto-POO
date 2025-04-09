package testes;

import static org.junit.jupiter.api.Assertions.*;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dados.MedicoArrayList;
import negocio.entidade.Medico;
import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.CrmApenasNumerosException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;
import negocio.NegocioMedico;
import negocio.repositorio.Medico.IRepositorioMedico;

class CadastroMedicoTest {
	private Medico medico1;
	private Medico medico2;
	private Medico medico3;
	private NegocioMedico negocio;
	private IRepositorioMedico repo;

	@BeforeEach
	void setUpBeforeClass() throws CpfApenasNumerosException, CrmApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException {
		repo = new MedicoArrayList();
		negocio = new NegocioMedico(repo);
		medico1 = new Medico("Dr. João", "98765432112", "joao@email.com", "81999999999", LocalDate.of(1990, 3, 20), "Cardiovascular", "123456",
				new ArrayList<>(List.of(DayOfWeek.TUESDAY, DayOfWeek.SATURDAY)),
				LocalTime.of(8, 0), LocalTime.of(12, 0)
				);
		
		medico2 = new Medico("Dr. Maria", "12345678978", "maria@gmail.com", "81789419999", LocalDate.of(2000, 5, 20), "Oftamologista", "456123",
				new ArrayList<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.MONDAY)),
				LocalTime.of(9, 0), LocalTime.of(15, 0)
				);
		
		medico3 = new Medico("Dr. Vanessa", "12345678978", "vanessa@gmail.com", "81778561998", LocalDate.of(1985, 5, 20), "Esteticista", "456987",
				new ArrayList<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.MONDAY)),
				LocalTime.of(7, 0), LocalTime.of(12, 0)
				);
		
	}
	@Test
	void cadastrosBemSucedidos() {
		try {
			negocio.adicionar(medico1);
			negocio.adicionar(medico2);
			System.out.println("Cadastro bem sucedido");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		assertNotEquals(medico1.getId(), medico2.getId());
		
		
		assertEquals(2, repo.quantidadeDeMedicos());
	}

	@Test
	void cadastroDeCpfJaExistente() {
		try{	
			negocio.adicionar(medico2);
			negocio.adicionar(medico3);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(1, repo.quantidadeDeMedicos());
		
	}
	
}
