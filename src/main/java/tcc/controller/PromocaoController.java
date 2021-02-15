package tcc.controller;

import tcc.common.Constante;
import tcc.common.bind.RequestDTO;
import tcc.common.http.ResponseDTO;
import tcc.dto.PromocaoDTO;
import tcc.model.Promocao;
import tcc.service.PromocaoService;

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
@RequestMapping(value = Constante.DIRETORIO_DA_PROMOCAO)
@Tag(name = "Promoções", description = "API das Promoções")
class PromocaoController {
		@Autowired
		private PromocaoService promocaoService;

			@Operation(summary = "Busca todas as promoções", tags = { "Promoções" })
		@GetMapping
		ResponseEntity<List<Promocao>> buscaTodasPromocoes() {
			return ResponseEntity.ok(promocaoService.buscaTodasPromocoes());
		}

		@Operation(summary = "Busca promoção por id", tags = { "Promoções" })
		@GetMapping(value = Constante.ACAO_HTTP_GET + Constante.DIRETORIO_DA_VARIAVEL_ID)
		ResponseEntity<Promocao> buscaPromocaoPorId(@PathVariable("id") Long PromocaoId) {
			return ResponseEntity.ok(promocaoService.buscaPromocaoPorId(PromocaoId));
		}

		@Operation(summary = "Cria uma promoção", tags = { "Promoções" })
		@PostMapping(value = Constante.ACAO_HTTP_POST)
		ResponseDTO<PromocaoDTO> criaConta(@RequestDTO(PromocaoDTO.class) @Validated Promocao promocao) {
			return ResponseDTO.accepted().convertTo(promocaoService.criaPromocao(promocao), PromocaoDTO.class);
		}

		@Operation(summary = "Atualiza todos os campos de uma promoção por id", tags = { "Promoções" })
		@PutMapping(value = Constante.ACAO_HTTP_PUT + Constante.DIRETORIO_DA_VARIAVEL_ID)
		ResponseEntity<Promocao> atualizaContaPorId(@PathVariable("id") Long PromocaoId, @RequestBody @Validated Promocao promocao) {
			return ResponseEntity.ok(promocaoService.atualizaPromocaoPorId(PromocaoId, promocao));
		}

		@Operation(summary = "Atualiza um ou mais campos de uma promoção por id", tags = { "Promoções" })
		@PatchMapping(value = Constante.ACAO_HTTP_PATCH + Constante.DIRETORIO_DA_VARIAVEL_ID)
		ResponseEntity<Promocao> atualizaParcialmenteContaPorId(@PathVariable("id") Long PromocaoId, @RequestBody @Validated Promocao promocao) {
			return ResponseEntity.ok(promocaoService.atualizaParcialmentePromocaoPorId(PromocaoId, promocao));
		}

		@Operation(summary = "Remove uma promoção", tags = { "Promoções" })
		@DeleteMapping(value = Constante.ACAO_HTTP_DELETE + Constante.DIRETORIO_DA_VARIAVEL_ID)
		ResponseEntity<Promocao> removeConta(@PathVariable("id") Long PromocaoId) {
			return ResponseEntity.ok(promocaoService.removePromocao(PromocaoId));
		}
}
