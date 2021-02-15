package tcc.dto;

import tcc.common.bind.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDTO {
	private Long reporteId;
	private ContaDTO contaId;
	private ComercioDTO comercioId;
	private String dataAbertura;
	private boolean catalogo;
	private boolean promocao;
	private String detalhes;
}
