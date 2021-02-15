package tcc.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import tcc.common.Constante;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import tcc.common.bind.RequestDTO;
import tcc.common.http.ResponseDTO;
import tcc.dto.ReporteDTO;
import tcc.model.Reporte;
import tcc.service.ReporteService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = Constante.DIRETORIO_DO_REPORTE)
@Tag(name = "Reportes", description = "API dos Reportes")
class ReporteController {
	@Autowired
	private ReporteService reporteService;

	@Operation(summary = "Busca todos os reportes", tags = { "Reportes" })
	@GetMapping
	ResponseEntity<List<Reporte>> buscaTodosReportes() {
		return ResponseEntity.ok(reporteService.buscaTodosReportes());
	}

	@Operation(summary = "Busca reporte por id", tags = { "Reportes" })
	@GetMapping(value = Constante.ACAO_HTTP_GET + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Reporte> buscaReportePorId(@PathVariable("catalogo_id") Long reporteId) {
		return ResponseEntity.ok(reporteService.buscaReportePorId(reporteId));
	}

	@Operation(summary = "Cria um reporte", tags = { "Reportes" })
	@PostMapping(value = Constante.ACAO_HTTP_POST)
	ResponseDTO<ReporteDTO> criaReporte(@RequestDTO(ReporteDTO.class) @Validated Reporte reporte) {
		return ResponseDTO.accepted().convertTo(reporteService.criaReporte(reporte), ReporteDTO.class);
	}

	@Operation(summary = "Atualiza todos os campos de um reporte", tags = { "Reportes" })
	@PutMapping(value = Constante.ACAO_HTTP_PUT + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Reporte> atualizaReportePorId(@PathVariable("id") Long reporteId, @RequestBody @Validated Reporte reporte) {
		return ResponseEntity.ok(reporteService.atualizaReportePorId(reporteId, reporte));
	}

	@Operation(summary = "Atualiza um ou mais campos de um reporte por id", tags = { "Reportes" })
	@PatchMapping(value = Constante.ACAO_HTTP_PATCH + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Reporte> atualizaParcialmenteReportePorId(@PathVariable("id") Long reporteId, @RequestBody @Validated Reporte reporte) {
		return ResponseEntity.ok(reporteService.atualizaParcialmenteReportePorId(reporteId, reporte));
	}

	@Operation(summary = "Remove um reporte", tags = { "Reportes" })
	@DeleteMapping(value = Constante.ACAO_HTTP_DELETE + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Reporte> removeReporte(@PathVariable("id") Long reporteId) {
		return ResponseEntity.ok(reporteService.removeReporte(reporteId));
	}

}
