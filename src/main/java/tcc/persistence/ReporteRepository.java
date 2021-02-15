package tcc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.model.Reporte;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}
