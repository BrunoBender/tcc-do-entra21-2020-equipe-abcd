package tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "promocao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promocao {
	@Id
	@Column(name = "promocao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long promocaoId;

	@ManyToOne
	@JoinColumn(name = "catalogo_id", nullable = false)
	private Catalogo catalogoId;

	@Column(name = "preco_promocional", nullable = false)
	private double precoPromocional;

	@Column(name = "data_inicio", length = 15, nullable = false)
	private String dataInicio;

	@Column(name = "data_fim", length = 15, nullable = false)
	private String dataFim;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	private LocalDateTime editadoEm;

	@Column(name = "ativo")
	private boolean ativo;

	@PrePersist
	public void executaAntesDeInserts() {
		criadoEm = LocalDateTime.now();
		editadoEm = LocalDateTime.now();
		ativo = true;
	}

	@PreUpdate
	public void executaAntesDeAtualizacoes() {
		editadoEm = LocalDateTime.now();
	}
}
