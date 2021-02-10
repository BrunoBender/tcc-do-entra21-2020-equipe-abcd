package tcc.controller;

import tcc.util.DTO;
import tcc.model.Conta;
import tcc.model.Catalogo;
import tcc.persistence.ContaRepository;
import tcc.persistence.CatalogoRepository;
import tcc.model.dto.ContaAtualizacaoDTO;
import tcc.model.dto.ContaCriacaoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/contas")
@Tag(name = "Contas", description = "API das Contas")
public class ContaRestController {
	private ContaRepository contaRepository;

	public ContaRestController(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@Operation(summary = "Busca todas as contas", tags = { "Contas" })
	@CrossOrigin
	@GetMapping("")
	public List<Conta> buscaTodasContas() {
		return contaRepository.findAll();
	}

	@Operation(summary = "Busca conta por id", tags = { "Contas" })
	@CrossOrigin
	@GetMapping("/id/{contaId}")
	public Optional<Conta> buscaContaPorId(@PathVariable long contaId) {
		return contaRepository.findById(contaId);
	}

	@Operation(summary = "Cria uma conta", tags = { "Contas" })
	@CrossOrigin
	@PostMapping("/cria")
	public void novaConta(@DTO(ContaCriacaoDTO.class) Conta conta) {
		contaRepository.save(conta);
	}

	@Operation(summary = "Atualiza todas as informações de uma conta por id", tags = { "Contas" })
	@CrossOrigin
	@PutMapping("/atualiza/{contaId}")
	public void atualizaConta(@DTO(ContaAtualizacaoDTO.class) Conta conta, @PathVariable long contaId) {
		conta.setContaId(contaId);
		contaRepository.save(conta);
	}

	@Operation(summary = "Busca conta por senha", tags = { "conta" })
	@CrossOrigin
	@GetMapping("/senha/{senha}")
	public Optional<Conta> buscaComercioPorSenha(@PathVariable String senha) {
		return contaRepository.findBySenha(senha);
	}

	@Operation(summary = "Busca conta por nome de usuário", tags = { "conta" })
	@CrossOrigin
	@GetMapping("/nomeusuario/{nomeUsuario}")
	public Optional<Conta> buscaComercioPorNomeUsuario(@PathVariable String nomeUsuario) {
		return contaRepository.findByNomeUsuario(nomeUsuario);
	}

	@Operation(summary = "Busca produto (?)", tags = { "conta" })
	@CrossOrigin
	@GetMapping("/produtos/todos")
	public List<Catalogo> buscaProdutos(CatalogoRepository catalogoRepository) {
		return catalogoRepository.findAll();
	}
}
