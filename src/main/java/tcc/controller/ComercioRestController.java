package tcc.controller;

import io.swagger.v3.oas.annotations.Operation;
import tcc.util.DTO;
import tcc.model.Comercio;
import tcc.persistence.ComercioRepository;
import tcc.model.dto.ComercioAtualizacaoDTO;
import tcc.model.dto.ComercioCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/comercios")
@Tag(name = "comercio", description = "API do Comercio")
public class ComercioRestController {
	private ComercioRepository comercioRepository;

	public ComercioRestController(ComercioRepository comercioRepository) {
		this.comercioRepository = comercioRepository;
	}

	@Operation(summary = "Busca todos os comércios", tags = { "comercio" })
	@CrossOrigin
	@GetMapping("/busca/todos")
	public List<Comercio> buscaTodosComercios() {
		return comercioRepository.findAll();
	}

	@Operation(summary = "Busca comércio por id", tags = { "comercio" })
	@CrossOrigin
	@GetMapping("/busca/{comercioId}")
	public Optional<Comercio> buscaComercioPorId(@PathVariable long comercioId) {
		return comercioRepository.findById(comercioId);
	}

	@Operation(summary = "Cadastra um comércio", tags = { "conta" })
	@CrossOrigin
	@PostMapping("/cria")
	public void novoComercio(@DTO(ComercioCriacaoDTO.class) Comercio comercio) {
		comercioRepository.save(comercio);
	}

	@Operation(summary = "Atualiza todas as informações de um comércio por id", tags = { "conta" })
	@CrossOrigin
	@PutMapping("/atualiza/{comercioId}")
	public void atualizaComercio(@DTO(ComercioAtualizacaoDTO.class) Comercio comercio, @PathVariable long comercioId) {
		comercio.setComercioId((comercioId));
		comercioRepository.save(comercio);
	}
}
