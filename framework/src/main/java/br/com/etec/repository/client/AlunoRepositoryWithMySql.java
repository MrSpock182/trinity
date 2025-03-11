package br.com.etec.repository.client;

import br.com.etec.repository.orm.AlunoOrmMySql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepositoryWithMySql extends JpaRepository<AlunoOrmMySql, Long> {
    Optional<AlunoOrmMySql> findByNome(String nome);
}
