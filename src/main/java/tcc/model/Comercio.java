package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "comercio")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Comercio {
	@Column(name = "comercio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long comercioId;

	@Column(name = "conta_id")
	@NotNull
	private long contaId;

	@Column(name = "nome_fantasia", length = 100)
	@NotNull
	private String nomeFantasia;

	@Column(name = "razao_social", length = 100)
	@NotNull
	private String razaoSocial;

	@Column(name = "cnpj", length = 20)
	@NotNull
	private String cnpj;

	@Column(name = "logradouro", length = 100)
	@NotNull
	private String logradouro;

	@Column(name = "numero_e_complemento", length = 100)
	@NotNull
	private String numeroEComplemento;

	@Column(name = "telefone", length = 15)
	@NotNull
	private String telefone;

	@Column(name = "cep", length = 10)
	@NotNull
	private String cep;

	@Column(name = "bairro", length = 50)
	@NotNull
	private String bairro;

	@Column(name = "cidade", length = 50)
	@NotNull
	private String cidade;

	@Column(name = "hash_contrato_social", length = 50)
	@NotNull
	private String hashContratoSocial;

	@Column(name = "criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name = "comercio_vip")
	@NotNull
	private boolean comercioVip;

	@Column(name = "ativo")
	@NotNull
	private boolean ativo;
}
