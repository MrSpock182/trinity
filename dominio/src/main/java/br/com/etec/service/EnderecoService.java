package br.com.etec.service;

import br.com.etec.entity.Aluno;
import br.com.etec.entity.AlunoEndereco;
import br.com.etec.integration.EnderecoIntegration;
import br.com.etec.repository.AlunoRepository;

public class EnderecoService {
    private final AlunoRepository repository;
    private final EnderecoIntegration integration;

    public EnderecoService(
            AlunoRepository repository,
            EnderecoIntegration integration) {
        this.repository = repository;
        this.integration = integration;
    }

    public Aluno enderecoAluno(final Aluno aluno) {
        final AlunoEndereco endereco = integration.endereco(aluno.endereco().numero(), aluno.endereco().cep());
        return repository.save(new Aluno(
                aluno.id(),
                aluno.nome(),
                aluno.cpf(),
                aluno.telefone(),
                aluno.email(),
                endereco));
    }
}