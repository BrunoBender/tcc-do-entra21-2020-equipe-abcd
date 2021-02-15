package tcc.service;

import tcc.common.util.Copia;
import tcc.model.Reporte;
import tcc.repository.ReporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * O serviço do tipo Reporte.
 */
@Service
@Transactional
public class ReporteService {
	@Autowired
	private ReporteRepository reporteRepository;

	/**
	 * Busca todos os reportes.
	 *
	 * @return uma lista dos reportes
	 */
	public List<Reporte> buscaTodosReportes() {
		return reporteRepository.findAll();
	}

	/**
	 * Busca reporte com o id informado.
	 *
	 * @param xID o id do reporte
	 * @return um reporte
	 */
	public Reporte buscaReportePorId(Long xID) {
		return reporteRepository.findById(xID).orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Cria novo reporte.
	 *
	 * @param xReporte o reporte a ser criado
	 * @return o reporte criado
	 */
	public Reporte criaReporte(Reporte xReporte) {
		return reporteRepository.save(xReporte);
	}

	/**
	 *  Atualiza todos os campos do reporte com o id informado.
	 *
	 * @param xID       o id do reporte
	 * @param xReporte o reporte a ser atualizado
	 * @return o reporte atualizado
	 */
	public Reporte atualizaReportePorId(Long xID, Reporte xReporte) {
		xReporte.setReporteId(xID);
		return reporteRepository.save(xReporte);
	}

	/**
	 * Atualiza parcialmente reporte com o id informado.
	 *
	 * @param xID       o id do reporte
	 * @param xReporte o reporte a ser atualizado
	 * @return o reporte atualizado
	 */
	public Reporte atualizaParcialmenteReportePorId(Long xID, Reporte xReporte) {
		Reporte reporte = buscaReportePorId(xID);
		Copia.copiaPropriedadesNaoNulas(xReporte, reporte);

		return reporteRepository.save(reporte);
	}

	/**
	 * Remove reporte com o id informado.
	 *
	 * @param xID o id do reporte
	 * @return o reporte removido
	 */
	public Reporte removeReporte(Long xID) {
		Reporte reporte = buscaReportePorId(xID);
		reporteRepository.delete(reporte);

		return reporte;
	}
}
