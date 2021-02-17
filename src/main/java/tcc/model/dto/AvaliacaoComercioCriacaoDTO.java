package tcc.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AvaliacaoComercioCriacaoDTO {
	@Column(name = "nota")
	@NotNull
	private double nota;
}
