package br.com.etec.integration.adapter;

import br.com.etec.entity.AlunoEndereco;
import br.com.etec.integration.dto.ViaCepResponse;

public class EnderecoIntegrationAdapter {
    private EnderecoIntegrationAdapter() {
    }

    public static AlunoEndereco cast(final String numero, final ViaCepResponse viaCep) {
        return new AlunoEndereco(
                viaCep.cep(),
                viaCep.logradouro(),
                numero,
                viaCep.bairro(),
                viaCep.localidade(),
                viaCep.uf());
    }
}