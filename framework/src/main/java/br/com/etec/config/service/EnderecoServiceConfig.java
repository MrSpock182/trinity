package br.com.etec.config.service;

import br.com.etec.integration.EnderecoIntegration;
import br.com.etec.repository.AlunoRepository;
import br.com.etec.service.EnderecoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoServiceConfig {
    @Bean
    public EnderecoService enderecoService(final AlunoRepository repository, final EnderecoIntegration integration) {
        return new EnderecoService(repository, integration);
    }
}