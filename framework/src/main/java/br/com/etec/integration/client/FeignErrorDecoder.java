package br.com.etec.integration.client;

import br.com.etec.exception.InternalServerError;
import br.com.etec.exception.NotFound;
import br.com.etec.exception.RequestTimeout;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return switch (response.status()) {
            case 404 -> new NotFound(response.toString());
            case 400, 408 -> new RequestTimeout(response.toString());
            default -> new InternalServerError(response.toString());
        };
    }
}