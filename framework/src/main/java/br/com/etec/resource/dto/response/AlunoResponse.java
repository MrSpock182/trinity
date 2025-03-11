package br.com.etec.resource.dto.response;

public record AlunoResponse(
        Long id,
        String nome,
        String telefone,
        String email,
        AlunoEnderecoResponse endereco
) {
}
