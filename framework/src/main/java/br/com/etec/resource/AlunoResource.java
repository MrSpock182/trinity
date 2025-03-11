package br.com.etec.resource;

import br.com.etec.entity.Aluno;
import br.com.etec.repository.AlunoRepository;
import br.com.etec.resource.adapter.AlunoResourceAdapter;
import br.com.etec.resource.dto.request.AlunoRequest;
import br.com.etec.resource.dto.response.AlunoResponse;
import br.com.etec.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Validated
@RestController
@RequestMapping("/trinity/v1")
public class AlunoResource {
    private final EnderecoService enderecoService;
    private final AlunoRepository alunoRepository;

    public AlunoResource(
            EnderecoService enderecoService,
            AlunoRepository alunoRepository) {
        this.enderecoService = enderecoService;
        this.alunoRepository = alunoRepository;
    }

    @ResponseStatus(OK)
    @PostMapping("/save")
    public AlunoResponse save(@RequestBody @Valid final AlunoRequest request) {
        final Aluno aluno = enderecoService.enderecoAluno(AlunoResourceAdapter.cast(request));
        return AlunoResourceAdapter.cast(aluno);
    }

    @ResponseStatus(OK)
    @GetMapping("/get-by-name")
    public AlunoResponse findByName(@RequestParam(name = "name") final String name) {
        final Aluno aluno = alunoRepository.findByName(name);
        return AlunoResourceAdapter.cast(aluno);
    }

    @ResponseStatus(OK)
    @GetMapping("/get-all")
    public List<AlunoResponse> findAll() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoResourceAdapter::cast)
                .toList();
    }

    @ResponseStatus(OK)
    @DeleteMapping("/delete")
    public void delete(@RequestParam(name = "id") final Long id) {
        alunoRepository.delete(id);
    }
}