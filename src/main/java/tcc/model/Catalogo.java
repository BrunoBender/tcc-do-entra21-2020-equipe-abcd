package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="catalogo")
public class Catalogo {
	@Column(name = "catalogo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long catalogoId;

	@Column(name = "produto")
	@NotNull
	private boolean produto;

	@Column(name = "categoria")
	@NotNull
	private String categoria;

	@Column(name = "nome_descritivo")
	@NotNull
	private String nomeDescritivo;

	@Column(name = "marca")
	@NotNull
	private String marca;

	@Column(name = "medida_usada")
	@NotNull
	private String medidaUsada;

	@Column(name = "quantidade_medida")
	@NotNull
	private double quantidadeMedida;

	@Column(name = "preco")
	@NotNull
	private double preco;

	@Column(name = "criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name = "item_vip")
	@NotNull
	private boolean itemVip;

	@Column(name = "ativo")
	@NotNull
	private boolean ativo;

	@NotNull
	@ManyToOne
	@JoinColumn(name="comercio_id")
	private Comercio comercio;

	public Catalogo(){

	}

	public Catalogo(long catalogoId, @NotNull boolean produto, @NotNull String categoria, @NotNull String nomeDescritivo, @NotNull String marca, @NotNull String medidaUsada, @NotNull double quantidadeMedida, @NotNull double preco, @NotNull LocalDateTime criadoEm, @NotNull LocalDateTime editadoEm, @NotNull boolean itemVip, @NotNull boolean ativo, Comercio comercio) {
		this.catalogoId = catalogoId;
		this.produto = produto;
		this.categoria = categoria;
		this.nomeDescritivo = nomeDescritivo;
		this.marca = marca;
		this.medidaUsada = medidaUsada;
		this.quantidadeMedida = quantidadeMedida;
		this.preco = preco;
		this.criadoEm = criadoEm;
		this.editadoEm = editadoEm;
		this.itemVip = itemVip;
		this.ativo = ativo;
		this.comercio = comercio;
	}








}
