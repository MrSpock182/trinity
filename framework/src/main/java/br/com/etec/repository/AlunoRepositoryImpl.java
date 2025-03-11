package br.com.etec.repository;

import br.com.etec.entity.Aluno;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {

    @Override
    public Aluno save(final Aluno aluno) {
        return null;
    }

    @Override
    public Aluno findByName(final String name) {
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        return List.of();
    }

    @Override
    public void delete(final String id) {

    }
}