package br.com.etec.repository.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class AlunoOrmMySql {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, length = 14)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(length = 15)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private AlunoEnderecoOrmMySql endereco;

    public AlunoOrmMySql() {
    }

    public AlunoOrmMySql(
            String nome,
            String cpf,
            String telefone,
            String email,
            AlunoEnderecoOrmMySql endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AlunoEnderecoOrmMySql getEndereco() {
        return endereco;
    }

    public void setEndereco(AlunoEnderecoOrmMySql endereco) {
        this.endereco = endereco;
    }
}
