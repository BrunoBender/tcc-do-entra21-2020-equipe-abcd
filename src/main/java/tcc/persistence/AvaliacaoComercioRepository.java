package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.model.AvaliacaoComercio;

public interface AvaliacaoComercioRepository extends JpaRepository<AvaliacaoComercio, Long> {
}
