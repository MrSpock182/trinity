package br.com.etec.resource;

import br.com.etec.entity.AlunoEndereco;
import br.com.etec.integration.EnderecoIntegration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class HelloResource {
    private final EnderecoIntegration integration;

    public HelloResource(EnderecoIntegration integration) {
        this.integration = integration;
    }

    @ResponseStatus(OK)
    @GetMapping("/hello")
    public AlunoEndereco findByName(final String name) {
        return integration.endereco("182", "06419310");
    }
}
