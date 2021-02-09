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

	@Column(name = "conta_id")
	@NotNull
	private long contaId;

	@Column(name = "comercio_id")
	@NotNull
	private long comercioId;

	@Column(name = "nota")
	@NotNull
	private double nota;
}
