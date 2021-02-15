package tcc.service;

import tcc.common.util.Copia;
import tcc.model.Promocao;
import tcc.repository.PromocaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * O serviço do tipo Promocao.
 */
@Service
@Transactional
public class PromocaoService {
	@Autowired
	private PromocaoRepository promocaoRepository;

	/**
	 * Busca todos as promocoes.
	 *
	 * @return uma lista das promocoes
	 */
	public List<Promocao> buscaTodasPromocoes() {
		return promocaoRepository.findAll();
	}

	/**
	 * Busca promocao com o id informado.
	 *
	 * @param xID o id da promocao
	 * @return uma promocao
	 */
	public Promocao buscaPromocaoPorId(Long xID) {
		return promocaoRepository.findById(xID).orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Cria nova promocao.
	 *
	 * @param xPromocao a promocao a ser criada
	 * @return a promocao criada
	 */
	public Promocao criaPromocao(Promocao xPromocao) {
		return promocaoRepository.save(xPromocao);
	}

	/**
	 *  Atualiza todos os campos da promocao com o id informado.
	 *
	 * @param xID       o id da promocao
	 * @param xPromocao a promocao a ser atualizada
	 * @return a promocao atualizada
	 */
	public Promocao atualizaPromocaoPorId(Long xID, Promocao xPromocao) {
		xPromocao.setPromocaoId(xID);
		return promocaoRepository.save(xPromocao);
	}

	/**
	 * Atualiza parcialmente promocao com o id informado.
	 *
	 * @param xID       o id da promocao
	 * @param xPromocao a promocao a ser atualizada
	 * @return a promocao atualizada
	 */
	public Promocao atualizaParcialmentePromocaoPorId(Long xID, Promocao xPromocao) {
		Promocao promocao = buscaPromocaoPorId(xID);
		Copia.copiaPropriedadesNaoNulas(xPromocao, promocao);

		return promocaoRepository.save(promocao);
	}

	/**
	 * Remove promocao com o id informado.
	 *
	 * @param xID o id da promocao
	 * @return a promocao removida
	 */
	public Promocao removePromocao(Long xID) {
		Promocao promocao = buscaPromocaoPorId(xID);
		promocaoRepository.delete(promocao);

		return promocao;
	}
}
