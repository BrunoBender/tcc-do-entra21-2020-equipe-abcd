package tcc.controller;

import tcc.common.Constante;
import tcc.common.bind.RequestDTO;
import tcc.common.http.ResponseDTO;
import tcc.model.Conta;
import tcc.dto.ContaDTO;
import tcc.service.ContaService;

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
@RequestMapping(value = Constante.DIRETORIO_DA_CONTA)
@Tag(name = "Contas", description = "API das Contas")
class ContaController {
	@Autowired
	private ContaService contaService;

	@Operation(summary = "Busca todas as contas", tags = { "Contas" })
	@GetMapping
	ResponseEntity<List<Conta>> buscaTodasContas() {
		return ResponseEntity.ok(contaService.buscaTodasContas());
	}

	@Operation(summary = "Busca conta por id", tags = { "Contas" })
	@GetMapping(value = Constante.ACAO_HTTP_GET + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Conta> buscaContaPorId(@PathVariable("id") Long contaId) {
		return ResponseEntity.ok(contaService.buscaContaPorId(contaId));
	}

	@Operation(summary = "Cria uma conta", tags = { "Contas" })
	@PostMapping(value = Constante.ACAO_HTTP_POST)
	ResponseDTO<ContaDTO> criaConta(@RequestDTO(ContaDTO.class) @Validated Conta conta) {
		return ResponseDTO.accepted().convertTo(contaService.criaConta(conta), ContaDTO.class);
	}

	@Operation(summary = "Atualiza todos os campos de uma conta por id", tags = { "Contas" })
	@PutMapping(value = Constante.ACAO_HTTP_PUT + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Conta> atualizaContaPorId(@PathVariable("id") Long contaId, @RequestBody @Validated Conta conta) {
		return ResponseEntity.ok(contaService.atualizaContaPorId(contaId, conta));
	}

	@Operation(summary = "Atualiza um ou mais campos de uma conta por id", tags = { "Contas" })
	@PatchMapping(value = Constante.ACAO_HTTP_PATCH + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Conta> atualizaParcialmenteContaPorId(@PathVariable("id") Long contaId, @RequestBody @Validated Conta conta) {
		return ResponseEntity.ok(contaService.atualizaParcialmenteContaPorId(contaId, conta));
	}

	@Operation(summary = "Remove uma conta", tags = { "Contas" })
	@DeleteMapping(value = Constante.ACAO_HTTP_DELETE + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Conta> removeConta(@PathVariable("id") Long contaId) {
		return ResponseEntity.ok(contaService.removeConta(contaId));
	}
}
