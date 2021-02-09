package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="comercio")
public class Comercio {
	@Column(name="comercio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long comercioId;

	@Column(name="conta_id")
	@NotNull
	private long contaId;

	@Column(name="nome_fantasia")
	@NotNull
	private String nomeFantasia;

	@Column(name="razao_social")
	@NotNull
	private String razaoSocial;

	@Column(name="cnpj")
	@NotNull
	private long cnpj;

	@Column(name="logradouro")
	@NotNull
	private String logradouro;

	@Column(name="numero_e_complemento")
	@NotNull
	private String numeroEComplemento;

	@Column(name="telefone")
	@NotNull
	private String telefone;

	@Column(name="cep")
	@NotNull
	private long cep;

	@Column(name="bairro")
	@NotNull
	private String bairro;

	@Column(name="cidade")
	@NotNull
	private String cidade;

	@Column(name="contrato_social_hash")
	@NotNull
	private String contratoSocialHash;

	@Column(name="criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name="editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name="comercio_vip")
	@NotNull
	private boolean comercioVip;

	@Column(name="ativo")
	@NotNull
	private boolean ativo;
}
