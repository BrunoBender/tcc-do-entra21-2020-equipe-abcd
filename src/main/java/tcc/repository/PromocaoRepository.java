package tcc.repository;

import tcc.model.Promocao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
}
