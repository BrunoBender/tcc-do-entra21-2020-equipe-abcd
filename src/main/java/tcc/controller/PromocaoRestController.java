package tcc.controller;

import tcc.util.DTO;
import tcc.model.Promocao;
import tcc.persistence.PromocaoRepository;
import tcc.model.dto.PromocaoAtualizacaoDTO;
import tcc.model.dto.PromocaoCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/promocoes")
@Tag(name = "Promoções", description = "API das Promoções")
public class PromocaoRestController {
	private PromocaoRepository promocaoRepository;

	public PromocaoRestController(PromocaoRepository promocaoRepository) {
		this.promocaoRepository = promocaoRepository;
	}

	@Operation(summary = "Busca todas as promoções", tags = { "Promoções" })
	@CrossOrigin
	@GetMapping("")
	public List<Promocao> buscaPromocoes() {
		return promocaoRepository.findAll();
	}

	@Operation(summary = "Busca promoção por id", tags = { "Promoções" })
	@CrossOrigin
	@GetMapping("/id/{promocaoId}")
	public Optional<Promocao> buscaPromocaoPorId(@PathVariable long promocaoId) {
		return promocaoRepository.findById(promocaoId);
	}

	@Operation(summary = "Cria uma promoção", tags = { "Promoções" })
	@CrossOrigin
	@PostMapping("/cria")
	public void novaPromocao(@DTO(PromocaoCriacaoDTO.class) Promocao promocao) {
		promocaoRepository.save(promocao);
	}

	@Operation(summary = "Atualiza todas as informações de uma promoção por id", tags = { "Promoções" })
	@CrossOrigin
	@PutMapping("/atualiza/{promocaoId}")
	public void atualizaPromocao(@DTO(PromocaoAtualizacaoDTO.class) Promocao promocao, @PathVariable long promocaoId) {
		promocao.setPromocaoId(promocaoId);
		promocaoRepository.save(promocao);
	}
}
