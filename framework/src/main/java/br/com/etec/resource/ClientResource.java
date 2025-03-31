package br.com.etec.resource;

import br.com.etec.messaging.UserProducerWithKafka;
import br.com.etec.resource.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1")
public class ClientResource {
    private final UserProducerWithKafka producer;

    public ClientResource(UserProducerWithKafka producer) {
        this.producer = producer;
    }

    @ResponseStatus(OK)
    @GetMapping("/healthcheck")
    public String healthcheck() {
        return "SUCCESS";
    }

    @ResponseStatus(OK)
    @PostMapping("/user")
    public String nameUser(@RequestBody final UserRequest request) {
        producer.produce(request.name());
        return request.name();
    }

    @ResponseStatus(OK)
    @GetMapping("/feliz")
    public String feliz() {
        return "O MARCELO ESTA FELIZ";
    }
}