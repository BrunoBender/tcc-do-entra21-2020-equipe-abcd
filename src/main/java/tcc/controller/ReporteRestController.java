package tcc.controller;

import tcc.util.DTO;
import tcc.model.Reporte;
import tcc.persistence.ReporteRepository;
import tcc.model.dto.ReporteAtualizacaoDTO;
import tcc.model.dto.ReporteCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reportes")
public class ReporteRestController {
	private ReporteRepository reporteRepository;

	public ReporteRestController(ReporteRepository reporteRepository) {
		this.reporteRepository = reporteRepository;
	}

	@CrossOrigin
	@GetMapping("/busca/todos")
	public List<Reporte> buscaReportes() {
		return reporteRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/busca/{reporteId}")
	public Optional<Reporte> buscaReportePorId(@PathVariable long reporteId) {
		return reporteRepository.findById(reporteId);
	}

	@CrossOrigin
	@PostMapping("/cria")
	public void novoReporte(@DTO(ReporteCriacaoDTO.class) Reporte reporte) {
		reporteRepository.save(reporte);
	}

	@CrossOrigin
	@PutMapping("/atualiza/{reporteId}")
	public void atualizaReporte(@DTO(ReporteAtualizacaoDTO.class) Reporte reporte, @PathVariable long reporteId) {
		reporte.setReporteId(reporteId);
		reporteRepository.save(reporte);
	}
}
