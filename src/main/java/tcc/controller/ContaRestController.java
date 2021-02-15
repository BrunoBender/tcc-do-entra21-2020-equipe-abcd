package tcc.controller;

import tcc.model.Conta;
import tcc.persistence.ContaRepository;
import tcc.model.dto.ContaAtualizacaoDTO;
import tcc.model.dto.ContaCriacaoDTO;
import java.util.List;
import java.util.Optional;
import tcc.util.DTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaRestController {
	private ContaRepository contaRepository;

	public ContaRestController(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@GetMapping("/busca/todas")
	public List<Conta> buscaTodasContas() {
		return contaRepository.findAll();
	}

	@GetMapping("/busca/{contaId}")
	public Optional<Conta> buscaContaPorId(@PathVariable long contaId) {
		return contaRepository.findById(contaId);
	}

	@PostMapping("/cria")
	public void novaConta(@DTO(ContaCriacaoDTO.class) Conta conta) {
		contaRepository.save(conta);
	}

	@PutMapping("/atualiza/{contaId}")
	public void atualizaConta(@DTO(ContaAtualizacaoDTO.class) Conta conta, @PathVariable long contaId) {
		conta.setContaId(contaId);

		contaRepository.save(conta);
	}
}
