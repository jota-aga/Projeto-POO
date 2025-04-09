
package iu.telaAdm;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import fachada.AssistenteFachada;
import fachada.ClinicaFachada;

import negocio.exceptions.*;


public class TelaGerenciamentoMedicoAdm {
    private final Scanner scanner;
    private final ClinicaFachada clinica;
    private final AssistenteFachada assistente;

    public TelaGerenciamentoMedicoAdm(ClinicaFachada clinica, AssistenteFachada assistente) {
        this.assistente = assistente;
        this.clinica = clinica;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("===== GERENCIAMENTO DE MÉDICO =====");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Remover Médico");
            System.out.println("3. Atualizar Médico");
            System.out.println("4. Listar Médicos");
            System.out.println("5. Listar Consultas de um Médico");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": cadastrarMedico(); break;
                case "2": removerMedico(); break;
                case "3": atualizarMedico(); break;
                case "4": listarMedicos(); break;
                case "5": listarConsultasMedico(); break;
                case "6": return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarMedico() {
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
            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();
            System.out.print("CRM: ");
            String crm = scanner.nextLine();

            System.out.print("Dias de Atendimento (ex: MONDAY, TUESDAY): ");
            String[] dias = scanner.nextLine().split(",");
            ArrayList<DayOfWeek> diasDeAtendimento = new ArrayList<>();
            for(String dia: dias) {
                diasDeAtendimento.add(DayOfWeek.valueOf(dia.trim().toUpperCase()));
            }

            System.out.print("Início atendimento (HH:MM): ");
            LocalTime inicio = LocalTime.parse(scanner.nextLine());
            System.out.print("Fim atendimento (HH:MM): ");
            LocalTime fim = LocalTime.parse(scanner.nextLine());

            clinica.adicionarMedico(nome, cpf, email, telefone, nascimento, especialidade, crm, diasDeAtendimento, inicio, fim);
            System.out.println("Cadastro realizado com sucesso!");

        } catch (MedicoJaExisteException e) {
            System.out.println(e.getMessage());
            System.out.println("O cadastro será reiniciado.");
            cadastrarMedico();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar médico: " + e.getMessage());
        }
    }


    private void removerMedico() {
        try {
            System.out.print("CPF do médico a remover: ");
            String cpf = scanner.nextLine();
            clinica.removerMedico(cpf);
            System.out.println("Médico removido com sucesso.");
        } catch (MedicoNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }


    private void atualizarMedico() {
        System.out.println("Digite o CPF do médico que deseja atualizar: ");
        String cpf = scanner.nextLine();
        try {
            System.out.print("Novo e-mail: ");
            String email = scanner.nextLine();
            System.out.print("Novo telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Nova especialidade: ");
            String especialidade = scanner.nextLine();
            System.out.print("Novo CRM: ");
            String crm = scanner.nextLine();

            System.out.print("Novos Dias de Atendimento (ex: MONDAY, TUESDAY): ");
            String[] dias = scanner.nextLine().split(",");
            ArrayList<DayOfWeek> diasDeAtendimento = new ArrayList<>();
            for(String dia: dias) {
                diasDeAtendimento.add(DayOfWeek.valueOf(dia.trim().toUpperCase()));
            }

            System.out.print("Novo Início atendimento (HH:MM): ");
            LocalTime inicio = LocalTime.parse(scanner.nextLine());
            System.out.print("Novo Fim atendimento (HH:MM): ");
            LocalTime fim = LocalTime.parse(scanner.nextLine());


            clinica.atualizarMedico(cpf, email, telefone, especialidade, crm, diasDeAtendimento, inicio, fim);
            System.out.println("Atualização realizada com sucesso!");
        } catch (MedicoNaoExisteException e) {
            System.out.println(e.getMessage());;
        }catch (Exception e){
            System.out.println("Não foi possível atualizar o médico: " + e.getMessage());
        }
    }

    private void listarConsultasMedico() {
        try {
            System.out.print("Digite o CPF do médico que deseja listar as consultas: ");
            String cpf = scanner.nextLine();
            assistente.listarConsultasDoMedico(cpf);
        } catch (MedicoNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarMedicos() {
        System.out.println("===== LISTA DE MÉDICOS =====");
        assistente.listarMedicos();
    }


}

