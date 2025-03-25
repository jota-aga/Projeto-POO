package src.Entidades;

import java.time.LocalDate;


public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;
	
	public Pessoa(String nome, String cpf, String email, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public abstract String getInformacoes();

	public abstract boolean equals(Object obj);
	
}
