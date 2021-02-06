package tcc.controller;

import tcc.model.Comercio;
import tcc.model.Conta;
import tcc.persistence.ContaRepository;
import tcc.model.dto.ContaAtualizacaoDTO;
import tcc.model.dto.ContaCriacaoDTO;
import java.util.List;
import java.util.Optional;
import tcc.util.DTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/contas")
public class ContaRestController {
	private ContaRepository contaRepository;


	public ContaRestController(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@CrossOrigin
	@GetMapping("/busca/todas")
	public List<Conta> buscaTodasContas() {
		return contaRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/busca/{contaId}")
	public Optional<Conta> buscaContaPorId(@PathVariable long contaId) {
		return contaRepository.findById(contaId);
	}

	@CrossOrigin
	@PostMapping("/cria")
	public void novaConta(@DTO(ContaCriacaoDTO.class) Conta conta) {
		contaRepository.save(conta);
	}

	@CrossOrigin
	@PutMapping("/atualiza/{contaId}")
	public void atualizaConta(@DTO(ContaAtualizacaoDTO.class) Conta conta, @PathVariable long contaId) {
		conta.setContaId(contaId);

		contaRepository.save(conta);
	}

	@CrossOrigin
	@GetMapping("/busca/senha/{senhaId}")
	public Optional<Conta> buscaComercioPorSenha(@PathVariable String senhaId) {
		return contaRepository.findBySenha(senhaId);
	}

	@CrossOrigin
	@GetMapping("/busca/nomeUsuario/{nomeUsuario}")
	public Optional<Conta> buscaComercioPorNomeUsuario(@PathVariable String nomeUsuario) {
		return contaRepository.findByNomeUsuario(nomeUsuario);
	}

	
}
