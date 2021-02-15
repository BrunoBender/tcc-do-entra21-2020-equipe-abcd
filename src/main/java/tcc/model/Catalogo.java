package tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "catalogo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalogo {
	@Id
	@Column(name = "catalogo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catalogoId;

	@ManyToOne
	@JoinColumn(name = "comercio_id", nullable = false)
	private Comercio comercioId;

	@Column(name = "produto")
	private boolean produto;

	@Column(name = "categoria", length = 50, nullable = false)
	private String categoria;

	@Column(name = "nome_descritivo", length = 100, nullable = false)
	private String nomeDescritivo;

	@Column(name = "marca", length = 50)
	private String marca;

	@Column(name = "medida_usada", length = 20)
	private String medidaUsada;

	@Column(name = "quantidade_medida", nullable = false)
	private double quantidadeMedida;

	@Column(name = "preco", nullable = false)
	private double preco;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	private LocalDateTime editadoEm;

	@Column(name = "item_vip")
	private boolean itemVip;

	@Column(name = "ativo")
	private boolean ativo;

	@PrePersist
	public void executaAntesDeInserts() {
		criadoEm = LocalDateTime.now();
		editadoEm = LocalDateTime.now();
		produto = true;
		marca = "Nao informado/Nao se aplica";
		medidaUsada = "Nao informado/Nao se aplica";
		itemVip = false;
		ativo = true;
	}

	@PreUpdate
	public void executaAntesDeAtualizacoes() {
		editadoEm = LocalDateTime.now();
	}
}
