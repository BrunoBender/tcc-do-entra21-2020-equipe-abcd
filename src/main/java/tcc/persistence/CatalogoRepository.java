package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.model.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
}
