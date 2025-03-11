package br.com.etec.integration;

import br.com.etec.entity.AlunoEndereco;
import br.com.etec.exception.RequestTimeout;
import br.com.etec.integration.adapter.EnderecoIntegrationAdapter;
import br.com.etec.integration.client.EnderecoIntegrationWithViacep;
import br.com.etec.integration.dto.ViaCepResponse;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class EnderecoIntegrationImpl implements EnderecoIntegration {
    private final EnderecoIntegrationWithViacep integration;

    public EnderecoIntegrationImpl(EnderecoIntegrationWithViacep integration) {
        this.integration = integration;
    }

    @Override
    @Retryable(
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000),
            retryFor = {RequestTimeout.class})
    public AlunoEndereco endereco(final String numero, final String cep) {
        System.out.println("Chamada para API com retry...");
        final ViaCepResponse endereco = integration.getEndereco(cep);
        return EnderecoIntegrationAdapter.cast(numero, endereco);
    }

    @Recover
    public AlunoEndereco recover(final String numero, final String cep) {
        System.out.println("Recuperação após falha: ");
        return new AlunoEndereco(
                cep,
                "ND",
                numero,
                "ND",
                "ND",
                "ND");
    }
}