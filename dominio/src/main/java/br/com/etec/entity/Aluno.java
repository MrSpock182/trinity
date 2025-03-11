package br.com.etec.entity;

public record Aluno(
        Integer id,
        String nome,
        String cpf,
        String telefone,
        AlunoEndereco endereco
) {
}