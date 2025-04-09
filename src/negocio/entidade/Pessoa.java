package negocio.entidade;
import java.time.LocalDate;


import negocio.exceptions.CpfApenasNumerosException;
import negocio.exceptions.CpfTamanhoInvalidoException;
import negocio.exceptions.TelefoneTamanhoInvalidoException;


public abstract class Pessoa {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    public Pessoa(String id, String nome, String cpf, String email, String telefone, LocalDate dataNascimento)
            throws CpfApenasNumerosException, CpfTamanhoInvalidoException, TelefoneTamanhoInvalidoException {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        ValidadorAtributos.validarCpf(cpf);
        ValidadorAtributos.validarTelefone(telefone);
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getInformacoes();

    public abstract boolean equals(Object obj);


}

