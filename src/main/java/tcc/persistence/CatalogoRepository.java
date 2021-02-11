package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tcc.model.Catalogo;
import tcc.model.Conta;

import java.util.List;
import java.util.Optional;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
    @Query("Select u from Catalogo u where u.nomeDescritivo = :nomeDescritivo")
    List<Catalogo> findByNomeDescritivo(@Param("nomeDescritivo") String nomeDescritivo);

    List<Catalogo> findByComercio_ComercioId(Long parseInt);

//    List<Catalogo> findByComercioId(Long comercioId);

//    List<Catalogo> findByComercioId(@Param("comercioId") Long comercioId);
}
