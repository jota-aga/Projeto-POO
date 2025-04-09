package main;

import fachada.AssistenteFachada;
import fachada.ClinicaFachada;
import fachada.PacienteFachada;

import iu.telaAdm.TelaPrincipal;
import iu.telaPaciente.TelaPaciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AssistenteFachada assistente = new AssistenteFachada();
        ClinicaFachada clinica = new ClinicaFachada();
        PacienteFachada pacienteF = new PacienteFachada();
        while (true) {
            System.out.println("========= SISTEMA DA CLÍNICA =========");
            System.out.println("1. Acesso Administrativo");
            System.out.println("2. Acesso Paciente");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    TelaPrincipal telaPrincipal = new TelaPrincipal(clinica, assistente);
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

