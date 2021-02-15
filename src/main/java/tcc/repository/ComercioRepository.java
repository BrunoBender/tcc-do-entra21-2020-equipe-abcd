package tcc.repository;

import tcc.model.Comercio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComercioRepository extends JpaRepository<Comercio, Long> {
}
