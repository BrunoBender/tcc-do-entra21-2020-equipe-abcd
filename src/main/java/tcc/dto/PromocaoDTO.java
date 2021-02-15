package tcc.dto;

import tcc.common.bind.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocaoDTO {
	private Long promocaoId;
	private CatalogoDTO catalogoId;
	private double precoPromocional;
	private String dataInicio;
	private String dataFim;
}
