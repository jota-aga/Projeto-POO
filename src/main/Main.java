package main;

import fachada.Clinica;
import fachada.PacienteF;

import iu.TelaAdm.TelaPrincipal;
import iu.TelaPaciente.TelaPaciente;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Clinica clinica = new Clinica();      // UI para médicos
		PacienteF pacienteF = new PacienteF(); // UI para pacientes

		while (true) {
			System.out.println("========= SISTEMA DA CLÍNICA =========");
			System.out.println("1. Acesso Administrativo");
			System.out.println("2. Acesso Paciente");
			System.out.println("3. Sair");
			System.out.print("Escolha uma opção: ");
			String opcao = scanner.nextLine();

			switch (opcao) {
				case "1":
					TelaPrincipal telaPrincipal = new TelaPrincipal(clinica);
					telaPrincipal.iniciar();
					break;
				case "2":
					TelaPaciente telaPaciente = new TelaPaciente(pacienteF);
					telaPaciente.iniciar();
					break;
				case "3":
					System.out.println("Encerrando o sistema...");
					return;
				default:
					System.out.println("Opção inválida.");
			}
		}
	}
}
