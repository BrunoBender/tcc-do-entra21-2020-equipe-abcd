package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
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
	private String cnpj;

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
	private String cep;

	@Column(name="bairro")
	@NotNull
	private String bairro;

	@Column(name="cidade")
	@NotNull
	private String cidade;

	@Column(name="hash_contrato_social")
	@NotNull
	private String HashContratoSocial;

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();

	@Column(name="comercio_vip")
	@NotNull
	private boolean comercioVip;

	@Column(name="ativo")
	@NotNull
	private boolean ativo;
}
