package tcc.service;

import tcc.common.util.Copia;
import tcc.model.Comercio;
import tcc.repository.ComercioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * O serviço do tipo Comercio.
 */
@Service
@Transactional
public class ComercioService {
	@Autowired
	private ComercioRepository comercioRepository;

	/**
	 * Busca todos os comercios.
	 *
	 * @return uma lista dos comercios
	 */
	public List<Comercio> buscaTodosComercios() {
		return comercioRepository.findAll();
	}

	/**
	 * Busca comercio com o id informado.
	 *
	 * @param xID o id do comercio
	 * @return um comercio
	 */
	public Comercio buscaComercioPorId(Long xID) {
		return comercioRepository.findById(xID).orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Cria novo comercio.
	 *
	 * @param xComercio o comercio a ser criado
	 * @return o comercio criado
	 */
	public Comercio criaComercio(Comercio xComercio) {
		return comercioRepository.save(xComercio);
	}

	/**
	 *  Atualiza todos os campos do comercio com o id informado.
	 *
	 * @param xID       o id do comercio
	 * @param xComercio o comercio a ser atualizado
	 * @return o comercio atualizado
	 */
	public Comercio atualizaComercioPorId(Long xID, Comercio xComercio) {
		xComercio.setComercioId(xID);
		return comercioRepository.save(xComercio);
	}

	/**
	 * Atualiza parcialmente comercio com o id informado.
	 *
	 * @param xID       o id do comercio
	 * @param xComercio o comercio a ser atualizado
	 * @return o comercio atualizado
	 */
	public Comercio atualizaParcialmenteComercioPorId(Long xID, Comercio xComercio) {
		Comercio comercio = buscaComercioPorId(xID);
		Copia.copiaPropriedadesNaoNulas(xComercio, comercio);

		return comercioRepository.save(comercio);
	}

	/**
	 * Remove comercio com o id informado.
	 *
	 * @param xID o id do comercio
	 * @return o comercio removido
	 */
	public Comercio removeComercio(Long xID) {
		Comercio comercio = buscaComercioPorId(xID);
		comercioRepository.delete(comercio);

		return comercio;
	}
}
