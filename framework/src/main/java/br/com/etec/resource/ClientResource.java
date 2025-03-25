package br.com.etec.resource;

import br.com.etec.resource.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class ClientResource {

    @ResponseStatus(OK)
    @GetMapping("/healthcheck")
    public String healthcheck() {
        return "SUCCESS";
    }

    @ResponseStatus(OK)
    @PostMapping("/user")
    public String nameUser(@RequestBody final UserRequest request) {
        return request.name();
    }

    @ResponseStatus(OK)
    @GetMapping("/update")
    public String update() {
        return "RECURSO ATUALIZADO";
    }

    @ResponseStatus(OK)
    @GetMapping("/novo")
    public String novo() {
        return "NOVO";
    }

    @ResponseStatus(OK)
    @GetMapping("/sandro")
    public String sandro() {
        return "SANDRO";
    }

}