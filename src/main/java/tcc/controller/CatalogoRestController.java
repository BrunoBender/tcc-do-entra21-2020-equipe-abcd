package tcc.controller;

import tcc.util.DTO;
import tcc.model.Catalogo;
import tcc.persistence.CatalogoRepository;
import tcc.model.dto.CatalogoAtualizacaoDTO;
import tcc.model.dto.CatalogoCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catalogos")
@Tag(name = "Catálogos", description = "API dos Catálogos")
public class CatalogoRestController {
	private CatalogoRepository catalogoRepository;

	public CatalogoRestController(CatalogoRepository catalogoRepository){
		this.catalogoRepository = catalogoRepository;
	}

	@Operation(summary = "Busca todas os itens", tags = { "Catálogos" })
	@CrossOrigin
	@GetMapping("")
	public List<Catalogo> buscaTodosCatalogos(){
		return catalogoRepository.findAll();
	}

	@Operation(summary = "Busca item por id", tags = { "Catálogos" })
	@CrossOrigin
	@GetMapping("/id/{itemId}")
	public Optional<Catalogo> buscaItemPorId(@PathVariable long itemId) {
		return catalogoRepository.findById(itemId);
	}

	@Operation(summary = "Cria um item", tags = { "Catálogos" })
	@CrossOrigin
	@PostMapping("/cria")
	public void novoItem(@DTO(CatalogoCriacaoDTO.class) Catalogo catalogo) {
		catalogoRepository.save(catalogo);
	}

	@Operation(summary = "Atualiza todas as informações de um item", tags = { "Catálogos" })
	@CrossOrigin
	@PutMapping("/atualiza/{itemId}")
	public void atualizaItem(@DTO(CatalogoAtualizacaoDTO.class) Catalogo catalogo, @PathVariable long itemId) {
		catalogo.setCatalogoId(itemId);
		catalogoRepository.save(catalogo);
	}

	@Operation(summary = "Busca item pelo nome descritivo", tags = { "Catálogos" })
	@CrossOrigin
	@GetMapping("/nomedescritivo/{nomeDescritivo}")
	public List<Catalogo> buscaNome(@PathVariable String nomeDescritivo){
		List<Catalogo> lista = catalogoRepository.findByNomeDescritivo(nomeDescritivo);
		return organizaPorPreco(lista);
	}

	@Operation(summary = "Organiza itens pelo preço", tags = { "Catálogos" })
	@CrossOrigin
	@GetMapping("TODO")
	public List<Catalogo> organizaPorPreco(List <Catalogo> lista){
		Catalogo temp;
		Double mLista = 0d;

		for(int j = 0; j < lista.size(); j++) {
			for(int i = 0; i <lista.size()-1; i++) {
				if (lista.get(i).getPreco() > lista.get(i+1).getPreco()) {
					temp = lista.get(i);
					lista.set(i, lista.get(i+1));
					lista.set(i+1, temp);
				}
			}
		}

		return lista;
	}
}
