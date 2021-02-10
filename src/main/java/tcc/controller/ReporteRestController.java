package tcc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Reportes", description = "API dos Reportes")
public class ReporteRestController {
	private ReporteRepository reporteRepository;

	public ReporteRestController(ReporteRepository reporteRepository) {
		this.reporteRepository = reporteRepository;
	}

	@Operation(summary = "Busca todas os reportes", tags = { "Reportes" })
	@CrossOrigin
	@GetMapping("")
	public List<Reporte> buscaReportes() {
		return reporteRepository.findAll();
	}

	@Operation(summary = "Busca promoção por id", tags = { "Reportes" })
	@CrossOrigin
	@GetMapping("/id/{reporteId}")
	public Optional<Reporte> buscaReportePorId(@PathVariable long reporteId) {
		return reporteRepository.findById(reporteId);
	}

	@Operation(summary = "Cria um reporte", tags = { "Reportes" })
	@CrossOrigin
	@PostMapping("/cria")
	public void novoReporte(@DTO(ReporteCriacaoDTO.class) Reporte reporte) {
		reporteRepository.save(reporte);
	}

	@Operation(summary = "Atualiza todas as informações de um reporte por id", tags = { "Reportes" })
	@CrossOrigin
	@PutMapping("/atualiza/{reporteId}")
	public void atualizaReporte(@DTO(ReporteAtualizacaoDTO.class) Reporte reporte, @PathVariable long reporteId) {
		reporte.setReporteId(reporteId);
		reporteRepository.save(reporte);
	}
}
