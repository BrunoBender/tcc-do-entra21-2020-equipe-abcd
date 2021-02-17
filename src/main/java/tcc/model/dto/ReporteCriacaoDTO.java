package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ReporteCriacaoDTO {
	@Column(name = "data_abertura", length = 15)
	@NotNull
	private String dataAbertura;

	@Column(name = "catalogo")
	@NotNull
	private boolean catalogo;

	@Column(name = "promocao")
	@NotNull
	private boolean promocao;

	@Column(name = "detalhes")
	@NotNull
	private String detalhes;

	@JsonIgnore
	private final LocalDateTime criadoEm = LocalDateTime.now();

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();
}
