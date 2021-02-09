package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="conta")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Conta {
	@Column(name="conta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long contaId;

	@Column(name="nome_usuario", length = 50)
	@NotNull
	private String nomeUsuario;

	@Column(name="nome", length = 100)
	@NotNull
	private String nome;

	@Column(name="telefone", length = 15)
	@NotNull
	private String telefone;

	@Column(name="cep", length = 10)
	@NotNull
	private String cep;

	@Column(name="email", length = 50)
	@NotNull
	private String email;

	@Column(name="senha", length = 30)
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
