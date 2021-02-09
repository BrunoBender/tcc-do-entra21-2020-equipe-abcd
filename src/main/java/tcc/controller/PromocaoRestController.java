package tcc.controller;

import tcc.util.DTO;
import tcc.model.Promocao;
import tcc.persistence.PromocaoRepository;
import tcc.model.dto.PromocaoAtualizacaoDTO;
import tcc.model.dto.PromocaoCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promocoes")
public class PromocaoRestController {
	private PromocaoRepository promocaoRepository;

	public PromocaoRestController(PromocaoRepository promocaoRepository) {
		this.promocaoRepository = promocaoRepository;
	}

	@CrossOrigin
	@GetMapping("/busca/todas")
	public List<Promocao> buscaPromocoes() {
		return promocaoRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/busca/{promocaoId}")
	public Optional<Promocao> buscaPromocaoPorId(@PathVariable long promocaoId) {
		return promocaoRepository.findById(promocaoId);
	}

	@CrossOrigin
	@PostMapping
	public void novaPromocao(@DTO(PromocaoCriacaoDTO.class) Promocao promocao) {
		promocaoRepository.save(promocao);
	}

	@CrossOrigin
	@PutMapping("/atualiza/{promocaoId}")
	public void atualizaPromocao(@DTO(PromocaoAtualizacaoDTO.class) Promocao promocao, @PathVariable long promocaoId) {
		promocao.setPromocaoId(promocaoId);
		promocaoRepository.save(promocao);
	}
}
