package src.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import src.Entidades.Paciente;
import src.Repositorio.RepositorioPaciente;


public class controllerPaciente {
	private RepositorioPaciente rep;
	private Scanner s = new Scanner(System.in);
	
	public Paciente lerPaciente()  {
	    String nome;
		long cpfTeste;
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
		cpfTeste = s.nextLong();
		s.nextLine();
		
		System.out.print("Digite a data de nascimento do paciente no formato XX XX XXXX : ");
		String dataFormatada = s.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        
       
        dataNascimento = LocalDate.parse(dataFormatada, formatter);
        String cpf =  String.valueOf(cpfTeste);
		Paciente p = new Paciente(nome, cpf, email, dataNascimento, cartaoMedico);
		return p;
	}
	
	public void cadastrarPaciente() {
		Paciente p = lerPaciente();
		rep.adicionarPaciente(p);
	}
	
	
	
	public void findByCpf() {
		long cpfTeste;
		String cpf;
		System.out.print("Digite o cpf que deseja procurar: ");
		cpfTeste = s.nextLong();
		s.nextLine();
		cpf = String.valueOf(cpfTeste);
		rep.procurarPorCpf(cpf);
	}
	
	public void removerPaciente() {
		long cpfTeste;
		String cpf;
		System.out.print("Digite o cpf que deseja procurar: ");
		cpfTeste = s.nextLong();
		s.nextLine();
		cpf = String.valueOf(cpfTeste);
		Paciente p = rep.procurarPorCpf(cpf);
		rep.removerPaciente(p);
		System.out.println("Remoção efetuada com sucesso");
		
	}
	
	public void editarPaciente() {
		String novaInfo;
		int opcao = 0;
		long cpfTeste;
		String cpf;
		
		System.out.print("Digite o CPF do paciente: ");
		cpfTeste = s.nextLong();
		
		cpf = String.valueOf(cpfTeste);
		Paciente p = rep.procurarPorCpf(cpf);
		
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
