package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.model.Catalogo;

import java.util.List;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
	List<Catalogo> findByNomeDescritivo(String nomeDescritivo);
}
