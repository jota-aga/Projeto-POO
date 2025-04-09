
package iu.telaAdm;

import fachada.AssistenteFachada;
import fachada.ClinicaFachada;
import negocio.entidade.Consulta;
import negocio.exceptions.PacienteNaoExisteException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TelaGerenciamentoPacienteAdm {

    private final Scanner scanner;
    private final ClinicaFachada clinica;
    private final AssistenteFachada assistente;

    public TelaGerenciamentoPacienteAdm(ClinicaFachada clinica, AssistenteFachada assistente) {
        this.assistente = assistente;
        this.clinica = clinica;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("===================================");
            System.out.println("        SISTEMA DE PACIENTE        ");
            System.out.println("===================================");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Remover Paciente");
            System.out.println("3. Atualizar Paciente");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Listar Consultas do Paciente");
            System.out.println("6. Agendar Consulta");
            System.out.println("7. Cancelar Consulta");
            System.out.println("8. Voltar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": cadastrarPaciente(); break;
                case "2": removerPaciente(); break;
                case "3": atualizarPaciente(); break;
                case "4": listarPacientes(); break;
                case "5": listarConsultasDoPaciente(); break;
                case "6": agendarConsulta(); break;
                case "7": cancelarConsulta(); break;
                case "8": return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarPaciente() {
        try {
            System.out.println("-----DADOS PESSOAIS-----");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Cpf: ");
            String cpf = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Data de Nascimento (YYYY-MM-DD): ");
            LocalDate nascimento = LocalDate.parse(scanner.nextLine());
            System.out.print("Cartao Medico: ");
            String cartaoMedico = scanner.nextLine();

            clinica.adicionarPaciente(nome, cpf, email, telefone, nascimento, cartaoMedico);
            System.out.println("Cadastro realizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar paciente: " + e.getMessage());
        }
    }

    private void removerPaciente() {
        try {
            System.out.print("CPF do paciente a remover: ");
            String cpf = scanner.nextLine();
            clinica.removerPaciente(cpf);
            System.out.println("Paciente removido com sucesso.");
        } catch (PacienteNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void atualizarPaciente() {
        System.out.println("Digite o CPF do paciente que deseja atualizar: ");
        String cpf = scanner.nextLine();
        try {
            System.out.println("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo e-mail: ");
            String email = scanner.nextLine();
            System.out.print("Novo telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Cartão médico: ");
            String cartaoMedico = scanner.nextLine();

            clinica.atualizarPaciente(nome, cpf, email, telefone, cartaoMedico);
            System.out.println("Atualização realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    private void listarPacientes() {
        System.out.println("===== LISTA DE PACIENTES =====");
        assistente.listarPacientes();
    }

    private void listarConsultasDoPaciente() {
        try {
            System.out.print("Digite o CPF do paciente: ");
            String cpf = scanner.nextLine();

            ArrayList<Consulta> consultas = clinica.listarConsultasDoPaciente(cpf);

            if(consultas.isEmpty()){
                System.out.println("Esse paciente não tem nenhuma consulta marcada.");
            }else{
                System.out.println("---Concultas do Paciente---");
                for (Consulta c : consultas) {
                    System.out.println(c);
                }
            }
        } catch (PacienteNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void agendarConsulta() {
        try {
            System.out.print("CPF do paciente: ");
            String cpf = scanner.nextLine();

            System.out.print("CRM do médico: ");
            String crm = scanner.nextLine();

            System.out.print("Data da consulta (YYYY-MM-DD): ");
            LocalDate data = LocalDate.parse(scanner.nextLine());

            System.out.print("Horário (HH:MM): ");
            LocalTime hora = LocalTime.parse(scanner.nextLine());

            clinica.agendarConsulta(crm, data, hora, cpf);
            System.out.println("Consulta agendada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao agendar: " + e.getMessage());
        }
    }

    private void cancelarConsulta() {
        try {
            System.out.print("CPF do paciente: ");
            String cpf = scanner.nextLine();

            System.out.print("Id: ");
            String id = scanner.nextLine();



            clinica.cancelarConsulta(id, cpf);
            System.out.println("Consulta cancelada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cancelar: " + e.getMessage());
        }
    }
}

