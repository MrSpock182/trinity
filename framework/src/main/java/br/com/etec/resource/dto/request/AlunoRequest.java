package br.com.etec.resource.dto.request;

public record AlunoRequest(
        Integer id,
        String nome,
        String cpf,
        String cep,
        String numero,
        String telefone
) {
}