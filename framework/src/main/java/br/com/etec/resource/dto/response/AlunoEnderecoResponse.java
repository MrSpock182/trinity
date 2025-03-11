package br.com.etec.resource.dto.response;

public record AlunoEnderecoResponse(
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String cidade
) {
}
