package tcc.controller;

import tcc.util.DTO;
import tcc.model.AvaliacaoComercio;
import tcc.persistence.AvaliacaoComercioRepository;
import tcc.model.dto.AvaliacaoComercioAtualizacaoDTO;
import tcc.model.dto.AvaliacaoComercioCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/avaliacoes")
@Tag(name = "Avaliações", description = "API das Avaliações dos Comércios")
public class AvaliacaoComercioRestController {
	private AvaliacaoComercioRepository avaliacaoComercioRepository;

	public AvaliacaoComercioRestController(AvaliacaoComercioRepository avaliacaoComercioRepository) {
		this.avaliacaoComercioRepository = avaliacaoComercioRepository;
	}

	@Operation(summary = "Busca todas as avaliações", tags = { "Avaliações" })
	@CrossOrigin
	@GetMapping("")
	public List<AvaliacaoComercio> buscaTodasAvaliacoes() {
		return avaliacaoComercioRepository.findAll();
	}

	@Operation(summary = "Busca avaliação por id", tags = { "Avaliações" })
	@CrossOrigin
	@GetMapping("/id/{avaliacaoId}")
	public Optional<AvaliacaoComercio> buscaAvaliacaoPorId(@PathVariable long avaliacaoId) {
		return avaliacaoComercioRepository.findById(avaliacaoId);
	}

	@Operation(summary = "Registra uma avaliação", tags = { "Avaliações" })
	@CrossOrigin
	@PostMapping("/cria")
	public void novaAvaliacao(@DTO(AvaliacaoComercioCriacaoDTO.class)AvaliacaoComercio avaliacaoComercio) {
		avaliacaoComercioRepository.save(avaliacaoComercio);
	}

	@Operation(summary = "Atualiza uma nota pelo id", tags = { "Avaliações" })
	@CrossOrigin
	@PutMapping("/atualiza/{avaliacaoId}")
	public void atualizaAvaliacao(@DTO(AvaliacaoComercioAtualizacaoDTO.class) AvaliacaoComercio avaliacaoComercio, @PathVariable long avaliacaoId) {
		avaliacaoComercio.setAvaliacaoComercioId(avaliacaoId);
		avaliacaoComercioRepository.save(avaliacaoComercio);
	}
}
