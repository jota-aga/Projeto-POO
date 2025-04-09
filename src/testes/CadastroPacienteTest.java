package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dados.PacienteArrayList;
import negocio.entidade.Paciente;
import negocio.NegocioPaciente;
import negocio.repositorio.paciente.IRepositorioPaciente;

class CadastroPacienteTest {
	private Paciente paciente1;
	private Paciente paciente2;
	private Paciente paciente3;
	private NegocioPaciente negocio;
	private IRepositorioPaciente repo;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		repo = new PacienteArrayList();
		negocio = new NegocioPaciente(repo);
		
		paciente1 = new Paciente("João", "12345678978", "joao@email.com", "12345678894", LocalDate.of(2004, 9, 10), "123456");
		paciente2 = new Paciente("Maria", "12345678978", "maria@email.com", "12345678945", LocalDate.of(2005, 5, 3), "456789" );
		paciente3 = new Paciente("Laura", "12345698765", "laura@email.com", "12365498569", LocalDate.of(2006, 7, 7), "456987");
	}

	@Test
	void cadastroDeCpfJaExistente() {
		try{
			negocio.adicionar(paciente1);
			negocio.adicionar(paciente2);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		assertTrue(repo.existe(paciente1.getCpf()));
		assertEquals(1, repo.quantidadePacientes());
		
	}
	
	@Test
	void cadastrosBemSucedidos() {
		try{negocio.adicionar(paciente1);
			negocio.adicionar(paciente3);
			System.out.println("cadastro bem sucedido");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		assertNotEquals(paciente1.getId(), paciente2.getId());
		assertTrue(repo.existe(paciente1.getCpf()));
		assertTrue(repo.existe(paciente2.getCpf()));
	}
	
	@Test
	void parametrosIncorretos() {
		Paciente paciente4 = null;
		Paciente paciente5 = null;
		Paciente paciente6 = null;
		
		try{
			paciente4 = new Paciente("Thays", "12398765", "thays@email.com", "1236544567869", LocalDate.of(2007, 7, 7), "487987");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			paciente5 = new Paciente("Luis", "12345678978", "thays@email.com", "12365445678699", LocalDate.of(2006, 6, 7), "787987");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			paciente6 = new Paciente("Luis", "1234567p978", "thays@email.com", "1236544567869", LocalDate.of(2006, 6, 7), "787987");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		assertEquals(null, paciente4);
		assertEquals(null, paciente5);
		assertEquals(null, paciente6);
			
	}
	
	

}
