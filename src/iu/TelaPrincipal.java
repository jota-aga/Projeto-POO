package iu;

import java.util.Scanner;

public class TelaPrincipal {

	private Scanner scanner;
	private TelaGerenciamentoMedico telaGMedico;
	private TelaGerenciamentoPaciente telaGPaciente;
	
	public TelaPrincipal() {
		this.scanner = new Scanner(System.in);
		telaGMedico = new TelaGerenciamentoMedico();
		telaGPaciente = new TelaGerenciamentoPaciente();
	}
	
	public void iniciar() {
		while(true) {
			  System.out.println("===================================");
		      System.out.println("        SISTEMA DE CLÍNICA       ");
		      System.out.println("===================================");
		      System.out.println("1. Gerenciar Médico.");
		      System.out.println("2. Gerenciar Paciente.");
		      System.out.println("3. Agenda.");
		      System.out.println("4. Sair.");
		      String opcao = scanner.nextLine();		      
		      
		      
		      switch(opcao) {
		      	case "1":
		      		telaGMedico.mostrarOpcoesM();
		      		break;
		      	case "2":
		      		telaGPaciente.mostrarOpcoesP();
		      		break;
		      	case "3":
		      }
		      
		}
	}
}
