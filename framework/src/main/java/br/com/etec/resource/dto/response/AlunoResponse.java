package br.com.etec.resource.dto.response;

public record AlunoResponse(
        Integer id,
        String nome,
        String telefone,
        AlunoEnderecoResponse endereco
) {
}
