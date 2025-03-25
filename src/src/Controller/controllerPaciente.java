package src.Controller;

import src.Exceptions.CpfApenasNumerosException;
import src.Exceptions.CpfNaoCadastradoException;
import src.Exceptions.CpfTamanhoInvalidoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import src.Entidades.Paciente;
import src.Repositorio.RepositorioPaciente;


public class controllerPaciente{
	private RepositorioPaciente rep;
	private Validador valida = new Validador();
	private Scanner s = new Scanner(System.in);
	
	public Paciente lerPaciente() throws CpfApenasNumerosException, CpfTamanhoInvalidoException {
	    String nome;
		String cpf;
		String cartaoMedico;
		String email;
		LocalDate dataNascimento = null;
		
		System.out.print("Digite o nome do paciente: ");
		nome = s.nextLine();
		
		System.out.print("Digite o cartão médico do paciente: ");
		cartaoMedico = s.nextLine();
		
		System.out.print("Digite o email do paciente: ");
		email = s.nextLine();
		
		System.out.print("Digite o CPF do paciente: ");
		cpf = s.nextLine();
		valida.validarCpf(cpf);
		
		System.out.print("Digite a data de nascimento do paciente no formato XX XX XXXX : ");
		String dataFormatada = s.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        
       
        dataNascimento = LocalDate.parse(dataFormatada, formatter);
		Paciente p = new Paciente(nome, cpf, email, dataNascimento, cartaoMedico);
		return p;
	}
	
	public void cadastrarPaciente() throws CpfApenasNumerosException, CpfTamanhoInvalidoException {
		Paciente p = lerPaciente();
		rep.adicionarPaciente(p);
	}
	
	
	
	public Paciente findByCpf() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, CpfNaoCadastradoException {
		
		String cpf;
		System.out.print("Digite o cpf que deseja procurar: ");
		cpf = s.nextLine();
		valida.validarCpf(cpf);
		
		
		Paciente p = rep.procurarPorCpf(cpf);
		
		if(p == null) {
			throw new CpfNaoCadastradoException();
		}
		
		return p;
	}
	
	public void removerPaciente() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, CpfNaoCadastradoException {
		
		String cpf;
		System.out.print("Digite o cpf que deseja procurar: ");
		cpf = s.nextLine();
		
		valida.validarCpf(cpf);
		
		
		Paciente p = rep.procurarPorCpf(cpf);
		if(p == null) {
			throw new CpfNaoCadastradoException();
		}
		rep.removerPaciente(p);
		System.out.println("Remoção efetuada com sucesso");
		
	}
	
	public void editarPaciente() throws CpfApenasNumerosException, CpfTamanhoInvalidoException, CpfNaoCadastradoException {
		String novaInfo;
		int opcao = 0;
		String cpf;
		
		System.out.print("Digite o CPF do paciente: ");
		cpf = s.nextLine();
		
		valida.validarCpf(cpf);
		
		
		Paciente p = rep.procurarPorCpf(cpf);
		
		if(p == null) {
			throw new CpfNaoCadastradoException();
		}
		
		System.out.println("Qual informação deseja editar\n1 - nome\n2 - email3 - Cartão Médico\n 4 - Data de nascimento\n");
		opcao = s.nextInt();
		s.nextLine();
		
		while(opcao < 1 || opcao > 4) {
			if(opcao == 1) {
				System.out.print("Digite o novo nome: ");
				novaInfo = s.nextLine();
				p.setNome(novaInfo);
			}
			
			else if(opcao == 2) {
				System.out.print("Digite o novo email: ");
				novaInfo = s.nextLine();
				p.setEmail(novaInfo);
			}
			
			else if( opcao == 3) {	
				System.out.print("Digite o novo cartão médico: ");
				novaInfo = s.nextLine();
				p.setCartaoMedico(novaInfo);
			}
			
			else if(opcao == 4) {
				System.out.print("Digite a nova data de nascimento: ");
				novaInfo = s.nextLine();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		        
			       
		        LocalDate dataNascimento = LocalDate.parse(novaInfo, formatter);
				
				
				p.setDataNascimento(dataNascimento);
			}
			
			else if(opcao == 5) {
				System.out.println("Saindo...");
			}
			
			else {
				System.out.println("Opção inválida!");
			}
		}
	}
}
