package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="conta")
public class Conta {
	@Column(name="conta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name="criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name="editado_em")
	@NotNull
	private LocalDateTime editadoEm;

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
