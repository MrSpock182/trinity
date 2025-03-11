package br.com.etec.repository;

import br.com.etec.entity.Aluno;

import java.util.List;

public interface AlunoRepository {
    Aluno save(Aluno aluno);

    Aluno findByName(String name);

    List<Aluno> findAll();

    void delete(Long id);
}
