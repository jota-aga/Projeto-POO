
package iu.TelaPaciente;

import fachada.PacienteF;
import negocio.Exceptions.PacienteNaoExisteException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TelaPaciente{
    private final Scanner scanner;
    private final PacienteF pacienteF;

    public TelaPaciente(PacienteF pacienteF) {
        this.pacienteF = pacienteF;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("Digite seu CPF para acessar como paciente: ");
        String cpf = scanner.nextLine();

        try {
            pacienteF.verificarCpf(cpf); // Valida se o CPF existe
        } catch (PacienteNaoExisteException e) {
            System.out.println("Paciente não encontrado: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("===== ÁREA DO PACIENTE =====");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Cancelar Consulta");
            System.out.println("3. Listar Minhas Consultas");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": agendarConsulta(cpf); break;
                case "2": cancelarConsulta(cpf); break;
                case "3": listarConsultas(cpf); break;
                case "4": return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private void agendarConsulta(String cpf) {
        try {
            System.out.print("CRM do médico: ");
            String crm = scanner.nextLine();

            System.out.print("Data da consulta (YYYY-MM-DD): ");
            LocalDate data = LocalDate.parse(scanner.nextLine());

            System.out.print("Horário (HH:MM): ");
            LocalTime hora = LocalTime.parse(scanner.nextLine());

            pacienteF.agendarConsulta(crm, data, hora, cpf);
            System.out.println("Consulta agendada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao agendar: " + e.getMessage());
        }
    }

    private void cancelarConsulta(String cpf) {
        try {
            System.out.print("CRM do médico: ");
            String crm = scanner.nextLine();

            System.out.print("Data da consulta (YYYY-MM-DD): ");
            LocalDate data = LocalDate.parse(scanner.nextLine());

            System.out.print("Horário (HH:MM): ");
            LocalTime hora = LocalTime.parse(scanner.nextLine());

            pacienteF.cancelarConsulta(crm, data, hora, cpf);
            System.out.println("Consulta cancelada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cancelar: " + e.getMessage());
        }
    }

    private void listarConsultas(String cpf) {
        try {
            pacienteF.listarConsultasDoPaciente(cpf);
        } catch (Exception e) {
            System.out.println("Erro ao listar consultas: " + e.getMessage());
        }
    }
}
