package br.com.etec.resource.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record AlunoRequest(
        @NotEmpty(message = "nome nao pode ser vazio")
        String nome,
        @NotEmpty(message = "cpf nao pode ser vazio")
        String cpf,
        @NotEmpty(message = "cep nao pode ser vazio")
        String cep,
        @NotEmpty(message = "numero nao pode ser vazio")
        String numero,
        @NotEmpty(message = "email nao pode ser vazio")
        String email,
        @NotEmpty(message = "telefone nao pode ser vazio")
        String telefone
) {
}