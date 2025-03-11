package br.com.etec.resource;

import br.com.etec.entity.Aluno;
import br.com.etec.repository.AlunoRepository;
import br.com.etec.resource.adapter.AlunoResourceAdapter;
import br.com.etec.resource.dto.request.AlunoRequest;
import br.com.etec.resource.dto.response.AlunoResponse;
import br.com.etec.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
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
    public AlunoResponse save(final AlunoRequest request) {
        final Aluno aluno = enderecoService.enderecoAluno(AlunoResourceAdapter.cast(request));
        return AlunoResourceAdapter.cast(aluno);
    }

    @ResponseStatus(OK)
    @GetMapping("/get-by-name")
    public AlunoResponse findByName(final String name) {
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
    public void delete(final String id) {
        alunoRepository.delete(id);
    }
}