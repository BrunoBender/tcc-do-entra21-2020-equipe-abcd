package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.model.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
}
