package tcc.controller;

import tcc.util.DTO;
import tcc.model.Comercio;
import tcc.persistence.ComercioRepository;
import tcc.model.dto.ComercioAtualizacaoDTO;
import tcc.model.dto.ComercioCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comercios")
public class ComercioRestController {
	private ComercioRepository comercioRepository;

	public ComercioRestController(ComercioRepository comercioRepository) {
		this.comercioRepository = comercioRepository;
	}

	@GetMapping("/busca/todos")
	public List<Comercio> buscaTodosComercios() {
		return comercioRepository.findAll();
	}

	@GetMapping("/busca/{comercioId}")
	public Optional<Comercio> buscaComercioPorId(@PathVariable long comercioId) {
		return comercioRepository.findById(comercioId);
	}

	@PostMapping("/cria")
	public void novoComercio(@DTO(ComercioCriacaoDTO.class) Comercio comercio) {
		comercioRepository.save(comercio);
	}

	@PutMapping("/atualiza/{comercioId}")
	public void atualizaComercio(@DTO(ComercioAtualizacaoDTO.class) Comercio comercio, @PathVariable long comercioId) {
		comercio.setComercioId((comercioId));

		comercioRepository.save(comercio);
	}
}
