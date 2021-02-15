package tcc.service;

import tcc.model.AvaliacaoComercio;
import tcc.repository.AvaliacaoComercioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * O serviço do tipo AvaliacaoComercio.
 */
@Service
@Transactional
public class AvaliacaoComercioService {
	@Autowired
	private AvaliacaoComercioRepository avaliacaoComercioRepository;

	/**
	 * Busca todos as notas dos comercios.
	 *
	 * @return uma lista das notas dos comercios
	 */
	public List<AvaliacaoComercio> buscaTodasNotas() {
		return avaliacaoComercioRepository.findAll();
	}

	/**
	 * Busca uma nota do comercio com o id informado.
	 *
	 * @param xID o id da notas do comercio
	 * @return uma nota do comercio
	 */
	public AvaliacaoComercio buscaNotaPorId(Long xID) {
		return avaliacaoComercioRepository.findById(xID).orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Cria nova nota do comercio.
	 *
	 * @param xAvaliacaoComercio a nota do comercio a ser criada
	 * @return a nota do comercio criada
	 */
	public AvaliacaoComercio criaNota(AvaliacaoComercio xAvaliacaoComercio) {
		return avaliacaoComercioRepository.save(xAvaliacaoComercio);
	}

	/**
	 *  Atualiza todos os campos da nota do comercio com o id informado.
	 *
	 * @param xID       o id da nota do comercio
	 * @param xAvaliacaoComercio a nota do comercio a ser atualizada
	 * @return a nota do comercio atualizada
	 */
	public AvaliacaoComercio atualizaNotaPorId(Long xID, AvaliacaoComercio xAvaliacaoComercio) {
		xAvaliacaoComercio.setAvaliacaoComercioId(xID);
		return avaliacaoComercioRepository.save(xAvaliacaoComercio);
	}

	/**
	 * Remove nota do comercio com o id informado.
	 *
	 * @param xID o id da nota do comercio
	 * @return a nota do comercio removida
	 */
	public AvaliacaoComercio removeNota(Long xID) {
		AvaliacaoComercio avaliacaoComercio = buscaNotaPorId(xID);
		avaliacaoComercioRepository.delete(avaliacaoComercio);

		return avaliacaoComercio;
	}
}
