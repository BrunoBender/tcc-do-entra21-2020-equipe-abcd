package tcc.controller;

import tcc.common.Constante;
import tcc.common.bind.RequestDTO;
import tcc.common.http.ResponseDTO;
import tcc.dto.CatalogoDTO;
import tcc.model.Catalogo;
import tcc.service.CatalogoService;

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
@RequestMapping(value = Constante.DIRETORIO_DO_ITEM_DO_CATALOGO)
@Tag(name = "Catálogos", description = "API dos Catálogos")
class CatalogoController {
	@Autowired
	private CatalogoService catalogoService;

	@Operation(summary = "Busca todos os itens dos catálogos", tags = { "Catálogos" })
	@GetMapping
	ResponseEntity<List<Catalogo>> buscaTodosItensDoCatalogo() {
		return ResponseEntity.ok(catalogoService.buscaTodosItensDoCatalogo());
	}

	@Operation(summary = "Busca item do catálogo por id", tags = { "Catálogos" })
	@GetMapping(value = Constante.ACAO_HTTP_GET + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Catalogo> buscaItemDoCatalogoPorId(@PathVariable("catalogo_id") Long catalogoId) {
		return ResponseEntity.ok(catalogoService.buscaItemDoCatalogoPorId(catalogoId));
	}

	@Operation(summary = "Cria um item no catálogo", tags = { "Catálogos" })
	@PostMapping(value = Constante.ACAO_HTTP_POST)
	ResponseDTO<CatalogoDTO> criaItemNoCatalogo(@RequestDTO(CatalogoDTO.class) @Validated Catalogo catalogo) {
		return ResponseDTO.accepted().convertTo(catalogoService.criaItemNoCatalogo(catalogo), CatalogoDTO.class);
	}

	@Operation(summary = "Atualiza todos os campos de um item do catálogo", tags = { "Catálogos" })
	@PutMapping(value = Constante.ACAO_HTTP_PUT + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Catalogo> atualizaItemDoCatalogoPorId(@PathVariable("id") Long catalogoId, @RequestBody @Validated Catalogo catalogo) {
		return ResponseEntity.ok(catalogoService.atualizaItemDoCatalogoPorId(catalogoId, catalogo));
	}

	@Operation(summary = "Atualiza um ou mais campos de um item do catálogo por id", tags = { "Catálogos" })
	@PatchMapping(value = Constante.ACAO_HTTP_PATCH + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Catalogo> atualizaParcialmenteItemDoCatalogoPorId(@PathVariable("id") Long catalogoId, @RequestBody @Validated Catalogo catalogo) {
		return ResponseEntity.ok(catalogoService.atualizaParcialmenteItemDoCatalogoPorId(catalogoId, catalogo));
	}

	@Operation(summary = "Remove um item do catálogo", tags = { "Catálogos" })
	@DeleteMapping(value = Constante.ACAO_HTTP_DELETE + Constante.DIRETORIO_DA_VARIAVEL_ID)
	ResponseEntity<Catalogo> removeItemDoCatalogo(@PathVariable("id") Long catalogoId) {
		return ResponseEntity.ok(catalogoService.removeItemDoCatalogo(catalogoId));
	}
}
