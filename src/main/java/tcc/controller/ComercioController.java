package tcc.controller;

import org.springframework.http.ResponseEntity;
import tcc.model.Comercio;
import tcc.persistence.ComercioRepository;
import tcc.model.dto.ComercioAtualizacaoDTO;
import tcc.model.dto.ComercioCriacaoDTO;
import java.util.List;
import java.util.Optional;
import tcc.util.DTO;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/comercios")
public class ComercioController {
	private ComercioRepository comercioRepository;

	public ComercioController(ComercioRepository comercioRepository) {
		this.comercioRepository = comercioRepository;
	}

	@CrossOrigin
	@GetMapping("/busca/todos")
	public List<Comercio> buscaTodosComercios() {
		return comercioRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/busca/{comercioId}")
	public Optional<Comercio> buscaComercioPorId(@PathVariable long comercioId) {
		return comercioRepository.findById(comercioId);
	}
	@CrossOrigin
	@GetMapping("/busca/userId/{contaId}")
	public List<Comercio> buscaComercioPorUserId(@PathVariable long contaId) {
		return comercioRepository.findBycontaId(contaId);
	}

	@CrossOrigin
	@PostMapping("/cria")
	public void novoComercio(@DTO(ComercioCriacaoDTO.class) Comercio comercio) {
		comercioRepository.save(comercio);
	}

	@CrossOrigin
	@PutMapping("/atualiza/{comercioId}")
	public void atualizaComercio(@DTO(ComercioAtualizacaoDTO.class) Comercio comercio, @PathVariable String comercioId) {
		comercio.setComercioId((Long.parseLong(comercioId)));

		comercioRepository.save(comercio);
	}
	@CrossOrigin
	@GetMapping("/busca/tipo/{razaoSocial}")
	public List <Comercio> buscaComercioPorRazaoSocial(@PathVariable String razaoSocial) {
			List<Comercio> lista = comercioRepository.findByRazaoSocial(razaoSocial);
		return lista;

	}

	@CrossOrigin
	@GetMapping("/busca/contaId/{contaId}")
	public List<Comercio> buscaComercioPorContaId(@PathVariable long contaId) {
		return comercioRepository.findByContaId(contaId);
	}

	@CrossOrigin
	@DeleteMapping("/{contaId}")
	@Transactional
	public void remover(@PathVariable String contaId){
		comercioRepository.deleteById(Long.parseLong(contaId));
	}


}
