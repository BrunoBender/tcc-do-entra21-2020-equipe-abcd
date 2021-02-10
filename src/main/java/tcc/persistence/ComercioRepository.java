package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tcc.model.Catalogo;
import tcc.model.Comercio;

import java.util.List;
import java.util.Optional;

public interface ComercioRepository extends JpaRepository<Comercio, Long> {
    @Query("Select u from Comercio u where u.razaoSocial = :razaoSocial")
    List<Comercio> findByRazaoSocial(@Param("razaoSocial") String razaoSocial);

    @Query("Select u from Comercio u where u.contaId = :contaId")
    List<Comercio> findByContaId(@Param("contaId") Long contaId);
}
