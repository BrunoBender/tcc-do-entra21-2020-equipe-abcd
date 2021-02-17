package tcc.controller;

import org.springframework.web.bind.annotation.*;
import tcc.model.AvaliacaoComercio;
import tcc.model.dto.AvaliacaoComercioAtualizacaoDTO;
import tcc.model.dto.AvaliacaoComercioCriacaoDTO;
import tcc.persistence.AvaliacaoComercioRepository;
import tcc.util.DTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoComercioController {
	private AvaliacaoComercioRepository avaliacaoComercioRepository;

	public AvaliacaoComercioController(AvaliacaoComercioRepository avaliacaoComercioRepository) {
		this.avaliacaoComercioRepository = avaliacaoComercioRepository;
	}

	@CrossOrigin
	@GetMapping("")
	public List<AvaliacaoComercio> buscaTodasAvaliacoes() {
		return avaliacaoComercioRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/id/{avaliacaoId}")
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
