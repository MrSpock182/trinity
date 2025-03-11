package br.com.etec.integration;

import br.com.etec.entity.AlunoEndereco;

public interface EnderecoIntegration {
    AlunoEndereco endereco(String numero, String cep);
}
