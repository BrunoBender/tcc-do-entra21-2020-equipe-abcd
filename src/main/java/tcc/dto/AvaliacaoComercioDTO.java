package tcc.dto;

import tcc.common.bind.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoComercioDTO {
	private Long avaliacaoComercioId;
	private ContaDTO contaId;
	private ComercioDTO comercioId;
	private double nota;
}
