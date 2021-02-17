package tcc.controller;

import org.springframework.web.bind.annotation.*;
import tcc.model.Reporte;
import tcc.model.dto.ReporteAtualizacaoDTO;
import tcc.model.dto.ReporteCriacaoDTO;
import tcc.persistence.ReporteRepository;
import tcc.util.DTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
	private ReporteRepository reporteRepository;

	public ReporteController(ReporteRepository reporteRepository) {
		this.reporteRepository = reporteRepository;
	}

	@CrossOrigin
	@GetMapping("")
	public List<Reporte> buscaReportes() {
		return reporteRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/id/{reporteId}")
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
