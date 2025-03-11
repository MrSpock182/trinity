package br.com.etec.repository.adapter;

import br.com.etec.entity.Aluno;
import br.com.etec.entity.AlunoEndereco;
import br.com.etec.repository.orm.AlunoEnderecoOrmMySql;
import br.com.etec.repository.orm.AlunoOrmMySql;

public class AlunoRepositoryAdapter {
    private AlunoRepositoryAdapter() {
    }

    public static Aluno cast(final AlunoOrmMySql sql) {
        final AlunoEnderecoOrmMySql endereco = sql.getEndereco();
        return new Aluno(
                sql.getId(),
                sql.getNome(),
                sql.getCpf(),
                sql.getTelefone(),
                sql.getEmail(),
                new AlunoEndereco(
                        endereco.getCep(),
                        endereco.getLogradouro(),
                        endereco.getNumero(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getUf()));
    }

    public static AlunoOrmMySql cast(final Aluno entity) {
        final AlunoEndereco endereco = entity.endereco();

        AlunoEnderecoOrmMySql alunoEndereco = new AlunoEnderecoOrmMySql();
        alunoEndereco.setCep(endereco.cep());
        alunoEndereco.setLogradouro(endereco.logradouro());
        alunoEndereco.setBairro(endereco.bairro());
        alunoEndereco.setCidade(endereco.cidade());
        alunoEndereco.setNumero(endereco.numero());
        alunoEndereco.setUf(endereco.uf());

        AlunoOrmMySql sql = new AlunoOrmMySql();
        sql.setNome(entity.nome());
        sql.setCpf(entity.cpf());
        sql.setTelefone(entity.telefone());
        sql.setEmail(entity.email());
        sql.setEndereco(alunoEndereco);

        return sql;
    }
}
