package tcc.model.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AvaliacaoComercioAtualizacaoDTO {
	@Column(name = "avaliacao_comercio_id")
	@NotNull
	@Id
	private long avaliacaoComercioId;

	@Column(name = "nota")
	@NotNull
	private double nota;
}
