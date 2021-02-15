package tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comercio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comercio {
	@Id
	@Column(name = "comercio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comercioId;

	@ManyToOne
	@JoinColumn(name = "conta_id", nullable = false)
	private Conta contaId;

	@Column(name = "nome_fantasia", length = 100, nullable = false)
	private String nomeFantasia;

	@Column(name = "razao_social", length = 100, nullable = false)
	private String razaoSocial;

	@Column(name = "cnpj", length = 20, nullable = false)
	private String cnpj;

	@Column(name = "logradouro", length = 100, nullable = false)
	private String logradouro;

	@Column(name = "numero_e_complemento", length = 100, nullable = false)
	private String numeroEComplemento;

	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;

	@Column(name = "cep", length = 10, nullable = false)
	private String cep;

	@Column(name = "bairro", length = 50, nullable = false)
	private String bairro;

	@Column(name = "cidade", length = 50, nullable = false)
	private String cidade;

	@Column(name = "hash_contrato_social", length = 50, nullable = false)
	private String hashContratoSocial;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	private LocalDateTime editadoEm;

	@Column(name = "comercio_vip")
	private boolean comercioVip;

	@Column(name = "ativo")
	private boolean ativo;

	@PrePersist
	public void executaAntesDeInserts() {
		criadoEm = LocalDateTime.now();
		editadoEm = LocalDateTime.now();
		comercioVip = false;
		ativo = true;
	}

	@PreUpdate
	public void executaAntesDeAtualizacoes() {
		editadoEm = LocalDateTime.now();
	}
}
