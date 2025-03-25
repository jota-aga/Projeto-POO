package src.Controller;

import src.Exceptions.CpfApenasNumerosException;
import src.Exceptions.CpfTamanhoInvalidoException;
import src.Exceptions.CrmApenasNumerosException;
import src.Exceptions.EspecialidadeNaoCadastradaException;
import src.Exceptions.CpfNaoCadastradoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import src.Entidades.Medico;
import src.Repositorio.RepositorioMedico;


public class controllerMedico {
	private RepositorioMedico rep = new RepositorioMedico();
	private Validador valida = new Validador();
	private Scanner s = new Scanner(System.in);
	
	public Medico lerMedico() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, CrmApenasNumerosException{
	    String nome;
		String cpf;
		String crm;
		String email;
		String especialidade;
		LocalDate dataNascimento;
		
		System.out.print("Digite o nome do médico: ");
		nome = s.nextLine();
		
		System.out.print("Digite o CRM do médico: ");
		crm = s.nextLine();
		valida.validarCrm(crm);
		
		
		System.out.print("Digite o email do médico: ");
		email = s.nextLine();
		
		System.out.print("Digite a especialidade do médico: ");
		especialidade = s.nextLine();
		
		System.out.print("Digite o CPF do médico: ");
		cpf = s.nextLine();
		valida.validarCpf(cpf);
		
		
		System.out.print("Digite a data de nascimento do médico no formato XX XX XXXX : ");
		String dataFormatada = s.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        
       
        dataNascimento = LocalDate.parse(dataFormatada, formatter);
		
        
		Medico m = new Medico(nome, cpf, email, dataNascimento, especialidade, crm);
		return m;
	}
	
	public void cadastrarMedico() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, CrmApenasNumerosException {
		Medico m = lerMedico();
		
		rep.adicionarMedico(m);
	}
	
	
	
	public Medico procurarCpf() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, CpfNaoCadastradoException {
		String cpf;
		System.out.print("Digite o cpf que deseja procurar: ");
		cpf = s.nextLine();
		valida.validarCpf(cpf);
		
		Medico m = rep.procurarPorCpf(cpf);
		if(m == null) {
			throw new CpfNaoCadastradoException();
		}
		return m;
	}
	
	public Medico procurarMedicosPorEspecialidade() throws EspecialidadeNaoCadastradaException {
		String especialidade;
		System.out.print("Digite a especialidade que deseja procurar: ");
		especialidade = s.nextLine();
		
		Medico m = rep.procurarPorEspecialidade(especialidade);
		
		if(m == null) {
			throw new EspecialidadeNaoCadastradaException();
		}
		return m;
	}
	
	public void excluirMedico() throws CpfNaoCadastradoException, CpfApenasNumerosException, CpfTamanhoInvalidoException {
		String cpf;
		
		System.out.print("Digite o cpf que deseja procurar: ");
		cpf = s.nextLine();
		s.nextLine();
		valida.validarCpf(cpf);
		
		Medico m = rep.procurarPorCpf(cpf);
		
		if(m == null) {
			throw new CpfNaoCadastradoException();
		}
		
		rep.removerMedico(m);
		System.out.println("Remoção efetuada com sucesso");
		
	}
	
	public void editarMedico() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, CpfNaoCadastradoException  {
		String novaInfo;
		int opcao = 0;
		
		String cpf;
		
		System.out.print("Digite o CPF do paciente: ");
		cpf = s.nextLine();
		s.nextLine();
		valida.validarCpf(cpf);
		
		Medico m = rep.procurarPorCpf(cpf);
		
		if(m == null) {
			throw new CpfNaoCadastradoException();
		}
		
		System.out.println("Qual informação deseja editar\n1 - nome\n2 - email3 - Especialidade\n 4 - Data de nascimento\n5 - Sair");
		opcao = s.nextInt();
		s.nextLine();
		
		while(opcao != 5) {
			if(opcao == 1) {
				System.out.print("Digite o novo nome: ");
				novaInfo = s.nextLine();
				m.setNome(novaInfo);
			}
			
			else if(opcao == 2) {
				System.out.print("Digite o novo email: ");
				novaInfo = s.nextLine();
				m.setEmail(novaInfo);
			}
			
			else if( opcao == 3) {	
				System.out.print("Digite o novo cartão médico: ");
				novaInfo = s.nextLine();
				m.setEspecialidade(novaInfo);
			}
			
			else if(opcao == 4) {
				System.out.print("Digite a nova data de nascimento: ");
				novaInfo = s.nextLine();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		        
			       
		        LocalDate dataNascimento = LocalDate.parse(novaInfo, formatter);
				
				
				m.setDataNascimento(dataNascimento);
			}
			
			else if(opcao == 5) {
				System.out.println("Saindo...");
			}
			
			else {
				System.out.println("Opção inválida! Tente novamente.");
			}
		}
	}
}
