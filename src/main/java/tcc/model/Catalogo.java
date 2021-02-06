package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="catalogo")
public class Catalogo {
	@Column(name="catalogo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long catalogoId;

	@Column(name="comercio_id")
	@NotNull
	private long comercioId;

	@Column(name="produto")
	@NotNull
	private boolean produto;

	@Column(name="categoria")
	@NotNull
	private String categoria;

	@Column(name="nome_descritivo")
	@NotNull
	private String nomeDescritivo;

	@Column(name="marca")
	@NotNull
	private String marca;

	@Column(name="medida_usada")
	@NotNull
	private String medidaUsada;

	@Column(name="quantidade_medida")
	@NotNull
	private double quantidadeMedida;

	@Column(name="preco")
	@NotNull
	private double preco;

	@Column(name="criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name="editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name="item_vip")
	@NotNull
	private boolean itemVip;

	@Column(name="ativo")
	@NotNull
	private boolean ativo;
}
