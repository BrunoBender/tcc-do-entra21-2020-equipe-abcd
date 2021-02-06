package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComercioAtualizacaoDTO {
	@Column(name="comercio_id")
	@NotNull
	@Id
	private long comercioId;

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

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();

	@Column(name="comercio_vip")
	@NotNull
	private boolean comercioVip;

	@Column(name="ativo")
	@NotNull
	private boolean ativo;
}
