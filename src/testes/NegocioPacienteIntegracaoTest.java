package testes;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dados.PacienteArrayList;
import negocio.entidade.Paciente;
import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.PacienteNaoExisteException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;
import negocio.NegocioPaciente;
import negocio.repositorio.paciente.IRepositorioPaciente;

class NegocioPacienteIntegracaoTest {
	private NegocioPaciente negocio;
	private IRepositorioPaciente repo;
	private Paciente paciente;
	private Paciente pacienteEditado;
	
	@BeforeEach
	void setUp() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException {
		repo = new PacienteArrayList();
		negocio = new NegocioPaciente(repo);
		paciente = new Paciente("João Henrique", "11245678978", "joao@email.com", "12567897894", LocalDate.of(2004, 10, 9), "123456");
	}
	

	@Test
	void atualizaPacienteSucesso() throws PacienteNaoExisteException, CpfApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException {
		try{
			negocio.adicionar(paciente);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		pacienteEditado = new Paciente("Maria Alves", "11245678978", "maria@email.com", "78945631233",LocalDate.of(2004, 10, 9), "654987");
		
		negocio.editarPaciente(pacienteEditado);
		paciente = negocio.findByCpf("11245678978");
		negocio.listarPacientes();
		
		assertEquals("Maria Alves", paciente.getNome());
		assertEquals("maria@email.com", paciente.getEmail());
		assertEquals("654987", paciente.getCartaoMedico());
		assertEquals("78945631233", paciente.getTelefone());
		
		//Confirma que apenas atualizou o que já existia
		assertEquals(1, repo.quantidadePacientes());

		
		
		
		
		
	}

}
