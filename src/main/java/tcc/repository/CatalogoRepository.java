package tcc.repository;

import tcc.model.Catalogo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
}
