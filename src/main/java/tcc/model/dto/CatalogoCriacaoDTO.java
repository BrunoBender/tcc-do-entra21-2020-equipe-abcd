package tcc.model.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CatalogoCriacaoDTO {
	@Column(name = "produto")
	@NotNull
	private boolean produto;

	@Column(name = "categoria", length = 50)
	@NotNull
	private String categoria;

	@Column(name = "nome_descritivo", length = 100)
	@NotNull
	private String nomeDescritivo;

	@Column(name = "marca", length = 50)
	@NotNull
	private String marca;

	@Column(name = "medida_usada", length = 20)
	@NotNull
	private String medidaUsada;

	@Column(name = "quantidade_medida")
	@NotNull
	private double quantidadeMedida;

	@Column(name = "preco")
	@NotNull
	private double preco;

	@JsonIgnore
	private final LocalDateTime editadoEm = LocalDateTime.now();

	@Column(name = "item_vip")
	@NotNull
	private boolean itemVip;

	@Column(name = "ativo")
	@NotNull
	private boolean ativo;
}
