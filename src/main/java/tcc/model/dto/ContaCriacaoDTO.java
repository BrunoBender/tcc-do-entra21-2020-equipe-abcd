package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCriacaoDTO {
	@Column(name="nome_usuario")
	@NotNull
	private String nomeUsuario;

	@Column(name="nome")
	@NotNull
	private String nome;

	@Column(name="telefone")
	@NotNull
	private long telefone;

	@Column(name="cep")
	@NotNull
	private long cep;

	@Column(name="email")
	@NotNull
	private String email;

	@Column(name="senha")
	@NotNull
	private String senha;

	@JsonIgnore
	private final LocalDateTime criadoEm = LocalDateTime.now();

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();

	@JsonIgnore
	private final LocalDateTime logarEm = LocalDateTime.now();
}
