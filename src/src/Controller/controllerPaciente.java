package src.Controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import src.Entidades.Paciente;
import src.Repositorio.RepositorioPaciente;


public class controllerPaciente {
	private RepositorioPaciente rep;
	private Scanner s = new Scanner(System.in);
	
	public void cadastrarPaciente()  {
	    String nome;
		long cpfTeste;
		String cartaoMedico;
		String email;
		Date dataNascimento = null;
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
			dataNascimento = sdf.parse(dataFormatada);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        String cpf =  String.valueOf(cpfTeste);
		Paciente p = new Paciente(nome, cpf, email, dataNascimento, cartaoMedico);
		rep.cadastrarPaciente(p);
		System.out.println("Cadastro efetuado com sucesso");
	}
	
	
	
	public void findByCpf() {
		long cpfTeste;
		String cpf;
		System.out.print("Digite o cpf que deseja procurar: ");
		cpfTeste = s.nextLong();
		s.nextLine();
		cpf = String.valueOf(cpfTeste);
		rep.findByCpf(cpf);
	}
	
	public void removerPaciente() {
		long cpfTeste;
		String cpf;
		System.out.print("Digite o cpf que deseja procurar: ");
		cpfTeste = s.nextLong();
		s.nextLine();
		cpf = String.valueOf(cpfTeste);
		Paciente p = rep.findByCpf(cpf);
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
		Paciente p = rep.findByCpf(cpf);
		
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
			
			else {
				System.out.println("Opção inválida!");
			}
		}
	}
}
