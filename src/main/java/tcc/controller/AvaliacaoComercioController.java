package tcc.controller;

import tcc.common.Constante;
import tcc.common.bind.RequestDTO;
import tcc.common.http.ResponseDTO;
import tcc.dto.AvaliacaoComercioDTO;
import tcc.model.AvaliacaoComercio;
import tcc.service.AvaliacaoComercioService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = Constante.DIRETORIO_DA_AVALIACAO)
@Tag(name = "Avaliações", description = "API das Avaliações")
class AvaliacaoComercioController {
	@Autowired
	private AvaliacaoComercioService avaliacaoComercioService;

	@Operation(summary = "Busca todas as avaliações", tags = { "Avaliações" })
	@GetMapping
	ResponseEntity<List<AvaliacaoComercio>> buscaTodasNotas() {
		return ResponseEntity.ok(avaliacaoComercioService.buscaTodasNotas());
	}

	@Operation(summary = "Busca avaliação por id", tags = { "Avaliações" })
	@GetMapping(value = Constante.ACAO_HTTP_GET + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<AvaliacaoComercio> buscaNotaPorId(@PathVariable("catalogo_id") Long avaliacaoComercioId) {
		return ResponseEntity.ok(avaliacaoComercioService.buscaNotaPorId(avaliacaoComercioId));
	}

	@Operation(summary = "Cria uma avaliação", tags = { "Avaliações" })
	@PostMapping(value = Constante.ACAO_HTTP_POST)
	ResponseDTO<AvaliacaoComercioDTO> criaNota(@RequestDTO(AvaliacaoComercioDTO.class) @Validated AvaliacaoComercio avaliacaoComercio) {
		return ResponseDTO.accepted().convertTo(avaliacaoComercioService.criaNota(avaliacaoComercio), AvaliacaoComercioDTO.class);
	}

	@Operation(summary = "Atualiza todos os campos de uma avaliação", tags = { "Avaliações" })
	@PutMapping(value = Constante.ACAO_HTTP_PUT + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<AvaliacaoComercio> atualizaItemDoCatalogoPorId(@PathVariable("id") Long avaliacaoComercioId, @RequestBody @Validated AvaliacaoComercio avaliacaoComercio) {
		return ResponseEntity.ok(avaliacaoComercioService.atualizaNotaPorId(avaliacaoComercioId, avaliacaoComercio));
	}

	@Operation(summary = "Remove uma avaliação", tags = { "Avaliações" })
	@DeleteMapping(value = Constante.ACAO_HTTP_DELETE + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<AvaliacaoComercio> removeNota(@PathVariable("id") Long avaliacaoComercioId) {
		return ResponseEntity.ok(avaliacaoComercioService.removeNota(avaliacaoComercioId));
	}
}
