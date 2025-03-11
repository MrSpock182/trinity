package br.com.etec.repository;

import br.com.etec.entity.Aluno;
import br.com.etec.exception.InternalServerError;
import br.com.etec.exception.NotFound;
import br.com.etec.repository.adapter.AlunoRepositoryAdapter;
import br.com.etec.repository.client.AlunoRepositoryWithMySql;
import br.com.etec.repository.orm.AlunoOrmMySql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final AlunoRepositoryWithMySql repository;

    public AlunoRepositoryImpl(AlunoRepositoryWithMySql repository) {
        this.repository = repository;
    }

    @Override
    public Aluno save(final Aluno aluno) {
        try {
            final AlunoOrmMySql sql = repository.save(AlunoRepositoryAdapter.cast(aluno));
            return AlunoRepositoryAdapter.cast(sql);
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }

    }

    @Override
    public Aluno findByName(final String name) {
        try {
            Optional<AlunoOrmMySql> optional = repository.findByNome(name);
            if (optional.isEmpty()) {
                throw new NotFound("Aluno não encontrado");
            }
            return AlunoRepositoryAdapter.cast(optional.get());
        } catch (NotFound ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
    }

    @Override
    public List<Aluno> findAll() {
        return repository.findAll()
                .stream()
                .map(AlunoRepositoryAdapter::cast)
                .toList();
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }
}