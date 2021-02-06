package tcc.persistence;

import tcc.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findBySenha(String senhaId);

    Optional<Conta> findByNomeUsuario(String nomeUsuario);
}
