package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.model.Comercio;

public interface ComercioRepository extends JpaRepository<Comercio, Long> {
}
