package tcc.controller;

import tcc.util.DTO;
import tcc.model.AvaliacaoComercio;
import tcc.persistence.AvaliacaoComercioRepository;
import tcc.model.dto.AvaliacaoComercioAtualizacaoDTO;
import tcc.model.dto.AvaliacaoComercioCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoComercioRestController {
	private AvaliacaoComercioRepository avaliacaoComercioRepository;

	public AvaliacaoComercioRestController(AvaliacaoComercioRepository avaliacaoComercioRepository) {
		this.avaliacaoComercioRepository = avaliacaoComercioRepository;
	}

	@CrossOrigin
	@GetMapping("/busca/todas")
	public List<AvaliacaoComercio> buscaTodasAvaliacoes() {
		return avaliacaoComercioRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/busca/{avaliacaoId}")
	public Optional<AvaliacaoComercio> buscaAvaliacaoPorId(@PathVariable long avaliacaoId) {
		return avaliacaoComercioRepository.findById(avaliacaoId);
	}

	@CrossOrigin
	@PostMapping("/cria")
	public void novaAvaliacao(@DTO(AvaliacaoComercioCriacaoDTO.class)AvaliacaoComercio avaliacaoComercio) {
		avaliacaoComercioRepository.save(avaliacaoComercio);
	}

	@CrossOrigin
	@PutMapping("/atualiza/{avaliacaoId}")
	public void atualizaAvaliacao(@DTO(AvaliacaoComercioAtualizacaoDTO.class) AvaliacaoComercio avaliacaoComercio, @PathVariable long avaliacaoId) {
		avaliacaoComercio.setAvaliacaoComercioId(avaliacaoId);
		avaliacaoComercioRepository.save(avaliacaoComercio);
	}
}
