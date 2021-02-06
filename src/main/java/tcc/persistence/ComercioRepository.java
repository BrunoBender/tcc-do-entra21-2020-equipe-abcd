package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.model.Comercio;

import java.util.Optional;

public interface ComercioRepository extends JpaRepository<Comercio, Long> {

}
