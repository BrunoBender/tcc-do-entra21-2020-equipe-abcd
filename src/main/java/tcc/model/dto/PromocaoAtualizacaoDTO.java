package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PromocaoAtualizacaoDTO {
	@Column(name = "promocao_id")
	@NotNull
	@Id
	private long promocaoId;

	@Column(name = "preco_promocional")
	@NotNull
	private double precoPromocional;

	@Column(name = "data_inicio", length = 15)
	@NotNull
	private String dataInicio;

	@Column(name = "data_fim", length = 15)
	@NotNull
	private String dataFim;

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();

	@Column(name = "ativo")
	@NotNull
	private boolean ativo;
}
