package tcc.service;

import tcc.common.util.Copia;
import tcc.model.Conta;
import tcc.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * O serviço do tipo Conta.
 */
@Service
@Transactional
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;


	/**
	 * Busca todas as contas.
	 *
	 * @return uma lista das contas
	 */
	public List<Conta> buscaTodasContas() {
		return contaRepository.findAll();
	}

	/**
	 * Busca conta com o id informado.
	 *
	 * @param xID o id da conta
	 * @return uma conta
	 */
	public Conta buscaContaPorId(Long xID) {
		return contaRepository.findById(xID).orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Cria nova conta.
	 *
	 * @param xConta a conta a ser criada
	 * @return a conta criada
	 */
	public Conta criaConta(Conta xConta) {
		return contaRepository.save(xConta);
	}

	/**
	 * Atualiza todos os campos da conta com o id informado.
	 *
	 * @param xID    o id da conta
	 * @param xConta a conta a ser atualizada
	 * @return a conta atualizada
	 */
	public Conta atualizaContaPorId(Long xID, Conta xConta) {
		xConta.setContaId(xID);
		return contaRepository.save(xConta);
	}

	/**
	 * Atualiza parcialmente conta com o id informado.
	 *
	 * @param xID    o id da conta
	 * @param xConta a conta a ser atualizada
	 * @return a conta atualizada
	 */
	public Conta atualizaParcialmenteContaPorId(Long xID, Conta xConta) {
		Conta conta = buscaContaPorId(xID);
		Copia.copiaPropriedadesNaoNulas(xConta, conta);

		return contaRepository.save(conta);
	}

	/**
	 * Remove conta com o id informado.
	 *
	 * @param xID o id da conta
	 * @return a conta removida
	 */
	public Conta removeConta(Long xID) {
		Conta conta = buscaContaPorId(xID);
		contaRepository.delete(conta);

		return conta;
	}
}
