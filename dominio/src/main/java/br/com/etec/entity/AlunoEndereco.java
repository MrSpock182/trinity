package br.com.etec.entity;

public record AlunoEndereco(
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String uf
) {
}