package tcc.service;

import tcc.common.util.Copia;
import tcc.model.Catalogo;
import tcc.repository.CatalogoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * O serviço do tipo Catalogo.
 */
@Service
@Transactional
public class CatalogoService {
	@Autowired
	private CatalogoRepository catalogoRepository;

	/**
	 * Busca todos os itens do catalogo.
	 *
	 * @return uma lista dos itens
	 */
	public List<Catalogo> buscaTodosItensDoCatalogo() {
		return catalogoRepository.findAll();
	}

	/**
	 * Busca item do catalogo com o id informado.
	 *
	 * @param xID o id do item do catalogo
	 * @return um item
	 */
	public Catalogo buscaItemDoCatalogoPorId(Long xID) {
		return catalogoRepository.findById(xID).orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Cria novo item no catalogo.
	 *
	 * @param xItem o item do catalogo a ser criado
	 * @return o item criado
	 */
	public Catalogo criaItemNoCatalogo(Catalogo xItem) {
		return catalogoRepository.save(xItem);
	}


	/**
	 *  Atualiza todos os campos do item do catalogo com o id informado.
	 *
	 * @param xID       o id do item do catalogo
	 * @param xCatalogo o item a ser atualizado
	 * @return o item atualizado
	 */
	public Catalogo atualizaItemDoCatalogoPorId(Long xID, Catalogo xCatalogo) {
		xCatalogo.setCatalogoId(xID);
		return catalogoRepository.save(xCatalogo);
	}

	/**
	 * Atualiza parcialmente item do catalogo com o id informado.
	 *
	 * @param xID       o id do item do catalogo
	 * @param xCatalogo o item do catalogo a ser atualizado
	 * @return o item atualizado
	 */
	public Catalogo atualizaParcialmenteItemDoCatalogoPorId(Long xID, Catalogo xCatalogo) {
		Catalogo catalogo = buscaItemDoCatalogoPorId(xID);
		Copia.copiaPropriedadesNaoNulas(xCatalogo, catalogo);

		return catalogoRepository.save(catalogo);
	}

	/**
	 * Remove item do catalogo com o id informado.
	 *
	 * @param xID o id do item do catalogo
	 * @return o item removido
	 */
	public Catalogo removeItemDoCatalogo(Long xID) {
		Catalogo catalogo = buscaItemDoCatalogoPorId(xID);
		catalogoRepository.delete(catalogo);

		return catalogo;
	}
}
