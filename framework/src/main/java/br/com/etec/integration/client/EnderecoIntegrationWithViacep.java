package br.com.etec.integration.client;

import br.com.etec.config.FeignConfiguration;
import br.com.etec.integration.dto.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "via-cep",
        url = "${feign.client.via-cep.url}",
        configuration = FeignConfiguration.class)
public interface EnderecoIntegrationWithViacep {
    @GetMapping("/{cep}/json/")
    ViaCepResponse getEndereco(@PathVariable("cep") final String cep);
}
