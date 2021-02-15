package tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "avaliacao_comercio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoComercio {
	@Id
	@Column(name = "avaliacao_comercio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long avaliacaoComercioId;

	@ManyToOne
	@JoinColumn(name = "conta_id", nullable = false)
	private Conta contaId;

	@ManyToOne
	@JoinColumn(name = "comercio_id", nullable = false)
	private Comercio comercioId;

	@Column(name = "nota", nullable = false)
	private double nota;
}
