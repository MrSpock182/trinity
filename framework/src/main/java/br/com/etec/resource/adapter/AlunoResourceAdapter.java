package br.com.etec.resource.adapter;

import br.com.etec.entity.Aluno;
import br.com.etec.entity.AlunoEndereco;
import br.com.etec.resource.dto.request.AlunoRequest;
import br.com.etec.resource.dto.response.AlunoEnderecoResponse;
import br.com.etec.resource.dto.response.AlunoResponse;

public class AlunoResourceAdapter {
    private AlunoResourceAdapter() {
    }

    public static Aluno cast(final AlunoRequest request) {
        return new Aluno(
                0,
                request.nome(),
                request.cpf(),
                request.telefone(),
                new AlunoEndereco(
                        request.cep(),
                        "",
                        request.numero(),
                        "",
                        "",
                        ""
                ));
    }

    public static AlunoResponse cast(final Aluno aluno) {
        return new AlunoResponse(
                aluno.id(),
                aluno.nome(),
                aluno.telefone(),
                new AlunoEnderecoResponse(
                        aluno.endereco().cep(),
                        aluno.endereco().logradouro(),
                        aluno.endereco().numero(),
                        aluno.endereco().bairro(),
                        aluno.endereco().cidade()));
    }
}