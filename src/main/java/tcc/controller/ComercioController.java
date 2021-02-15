package tcc.controller;

import tcc.common.Constante;
import tcc.common.bind.RequestDTO;
import tcc.common.http.ResponseDTO;
import tcc.model.Comercio;
import tcc.dto.ComercioDTO;
import tcc.service.ComercioService;

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
@RequestMapping(value = Constante.DIRETORIO_DO_COMERCIO)
@Tag(name = "Comércios", description = "API dos Comércios")
class ComercioController {
	@Autowired
	private ComercioService comercioService;

	@Operation(summary = "Busca todos os comércios", tags = { "Comércios" })
	@GetMapping
	ResponseEntity<List<Comercio>> buscaTodosComercios() {
		return ResponseEntity.ok(comercioService.buscaTodosComercios());
	}

	@Operation(summary = "Busca comércio por id", tags = { "Comércios" })
	@GetMapping(value = Constante.ACAO_HTTP_GET + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Comercio> buscaComercioPorId(@PathVariable("comercio_id") Long comercioId) {
		return ResponseEntity.ok(comercioService.buscaComercioPorId(comercioId));
	}

	@Operation(summary = "Cria um comércio", tags = { "Comércios" })
	@PostMapping(value = Constante.ACAO_HTTP_POST)
	ResponseDTO<ComercioDTO> criaComercio(@RequestDTO(ComercioDTO.class) @Validated Comercio comercio) {
		return ResponseDTO.accepted().convertTo(comercioService.criaComercio(comercio), ComercioDTO.class);
	}

	@Operation(summary = "Atualiza todos os campos de um comércio por id", tags = { "Comércios" })
	@PutMapping(value = Constante.ACAO_HTTP_PUT + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Comercio> atualizaComercioPorId(@PathVariable("comercio_id") Long comercioId, @RequestBody @Validated Comercio comercio) {
		return ResponseEntity.ok(comercioService.atualizaComercioPorId(comercioId, comercio));
	}

	@Operation(summary = "Atualiza um ou mais campos de um comércio por id", tags = { "Comércios" })
	@PatchMapping(value = Constante.ACAO_HTTP_PATCH + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Comercio> atualizaParcialmenteComercioPorId(@PathVariable("comercio_id") Long comercioId, @RequestBody @Validated Comercio comercio) {
		return ResponseEntity.ok(comercioService.atualizaParcialmenteComercioPorId(comercioId, comercio));
	}

	@Operation(summary = "Remove um comércio", tags = { "Comércios" })
	@DeleteMapping(value = Constante.ACAO_HTTP_DELETE + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Comercio> removeComercio(@PathVariable("comercio_id") Long comercioId) {
		return ResponseEntity.ok(comercioService.removeComercio(comercioId));
	}
}
