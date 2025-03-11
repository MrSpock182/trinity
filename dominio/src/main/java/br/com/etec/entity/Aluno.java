package br.com.etec.entity;

public record Aluno(
        Long id,
        String nome,
        String cpf,
        String telefone,
        String email,
        AlunoEndereco endereco
) {
}