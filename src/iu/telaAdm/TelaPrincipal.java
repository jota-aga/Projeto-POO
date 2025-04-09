package iu.telaAdm;

import java.util.Scanner;

import fachada.AssistenteFachada;
import fachada.ClinicaFachada;

public class TelaPrincipal {

    private Scanner scanner;
    private TelaGerenciamentoMedicoAdm telaGMedico;
    private TelaGerenciamentoPacienteAdm telaGPaciente;

    public TelaPrincipal(ClinicaFachada clinica, AssistenteFachada assistente) {
        this.scanner = new Scanner(System.in);
        telaGMedico = new TelaGerenciamentoMedicoAdm(clinica, assistente);
        telaGPaciente = new TelaGerenciamentoPacienteAdm(clinica, assistente);
    }

    public void iniciar() {
        while(true) {
            System.out.println("===================================");
            System.out.println("        SISTEMA DE CLÍNICA       ");
            System.out.println("===================================");
            System.out.println("1. Gerenciar Médico.");
            System.out.println("2. Gerenciar Paciente.");
            System.out.println("3. Sair.");
            String opcao = scanner.nextLine();


            switch(opcao) {
                case "1":
                    telaGMedico.iniciar();
                    break;
                case "2":
                    telaGPaciente.iniciar();
                    break;
                case "3":
                    System.out.println("Saindo do sistema.");
                    return;
                default:
                    System.out.println("Opção Inválida");
            }

        }
    }
}

