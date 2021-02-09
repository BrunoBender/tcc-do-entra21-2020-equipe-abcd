package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ComercioAtualizacaoDTO {
	@Column(name = "comercio_id")
	@NotNull
	@Id
	private long comercioId;

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

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();

	@Column(name = "comercio_vip")
	@NotNull
	private boolean comercioVip;

	@Column(name = "ativo")
	@NotNull
	private boolean ativo;
}
