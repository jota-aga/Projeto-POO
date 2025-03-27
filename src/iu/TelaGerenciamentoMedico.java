package iu;

import java.util.Scanner;

public class TelaGerenciamentoMedico {

	private Scanner scanner;
	
	public TelaGerenciamentoMedico() {
		this.scanner = new Scanner(System.in);
	}
	
	
	public void mostrarOpcoesM() {
		 System.out.println("===================================");
	     System.out.println("        SISTEMA DE CLÍNICA       ");
	     System.out.println("===================================");
	     System.out.println("1. Adicionar Médico");
	     System.out.println("2. Remover Médico");
	     System.out.println("3. Atualizar Médico");
	     System.out.println("4. Listar Médico(s)");
	     String opcao = scanner.nextLine();
	     
	     
	
	}


	
}
