package tcc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "avaliacao_comercio")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class AvaliacaoComercio {
	@Column(name = "avaliacao_comercio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long avaliacaoComercioId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_id")
	@NotNull
	private Conta conta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comercio_id")
	@NotNull
	private Comercio comercio;

	@Column(name = "nota")
	@NotNull
	private double nota;
}
