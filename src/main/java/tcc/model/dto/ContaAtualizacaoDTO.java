package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ContaAtualizacaoDTO {
	@Column(name="conta_id")
	@NotNull
	@Id
	private long contaId;

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
	private final LocalDateTime editadoEm = LocalDateTime.now();

	@Column(name="empreendedor")
	@NotNull
	private boolean empreendedor;

	@Column(name="admin_plataforma")
	@NotNull
	private boolean adminPlataforma;

	@Column(name="ativo")
	@NotNull
	private boolean ativo;
}
