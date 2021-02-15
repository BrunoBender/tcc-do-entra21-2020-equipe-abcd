package tcc.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="avaliacao_comercio")
public class AvaliacaoComercio {
	@Column(name="avaliacao_comercio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long avaliacaoComercioId;

	@Column(name="conta_id")
	@NotNull
	private long contaId;

	@Column(name="comercio_id")
	@NotNull
	private long comercioId;

	@Column(name="nota")
	@NotNull
	private double nota;
}
