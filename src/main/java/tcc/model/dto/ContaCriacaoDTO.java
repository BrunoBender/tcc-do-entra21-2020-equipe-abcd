package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ContaCriacaoDTO {
	@Column(name = "nome_usuario", length = 50)
	@NotNull
	private String nomeUsuario;

	@Column(name = "nome", length = 100)
	@NotNull
	private String nome;

	@Column(name = "telefone", length = 15)
	@NotNull
	private String telefone;

	@Column(name = "cep", length = 10)
	@NotNull
	private String cep;

	@Column(name = "email", length = 50)
	@NotNull
	private String email;

	@Column(name = "senha", length = 30)
	@NotNull
	private String senha;

	@JsonIgnore
	private final LocalDateTime criadoEm = LocalDateTime.now();

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();
}
