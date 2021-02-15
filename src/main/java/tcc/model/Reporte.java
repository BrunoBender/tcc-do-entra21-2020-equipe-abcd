package tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
	@Id
	@Column(name = "reporte_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reporteId;

	@ManyToOne
	@JoinColumn(name = "conta_id", nullable = false)
	private Conta contaId;

	@ManyToOne
	@JoinColumn(name = "comercio_id", nullable = false)
	private Comercio comercioId;

	@Column(name = "data_abertura", length = 15, nullable = false)
	private String dataAbertura;

	@Column(name = "catalogo")
	private boolean catalogo;

	@Column(name = "promocao")
	private boolean promocao;

	@Column(name = "detalhes", length = 4000, nullable = false)
	private String detalhes;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	private LocalDateTime editadoEm;

	@Column(name = "data_conclusao", length = 15)
	private String dataConclusao;

	@Column(name = "resolucao", length = 4000)
	private String resolucao;

	@Column(name = "ativo")
	private boolean ativo;

	@PrePersist
	public void executaAntesDeInserts() {
		criadoEm = LocalDateTime.now();
		editadoEm = LocalDateTime.now();
		catalogo = false;
		promocao = false;
		dataConclusao = "Reporte em analise";
		resolucao = "Reporte em analise";
		ativo = true;
	}

	@PreUpdate
	public void executaAntesDeAtualizacoes() {
		editadoEm = LocalDateTime.now();
	}
}
