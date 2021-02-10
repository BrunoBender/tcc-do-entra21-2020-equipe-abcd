package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "reporte")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Reporte {
	@Column(name = "reporte_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long reporteId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_id")
	@NotNull
	private Conta conta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comercio_id")
	@NotNull
	private Comercio comercio;

	@Column(name = "data_abertura", length = 15)
	@NotNull
	private String dataAbertura;

	@Column(name = "catalogo")
	@NotNull
	private boolean catalogo;

	@Column(name = "promocao")
	@NotNull
	private boolean promocao;

	@Column(name = "detalhes")
	@NotNull
	private String detalhes;

	@Column(name = "criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name = "data_conclusao", length = 15)
	@NotNull
	private String dataConclusao;

	@Column(name = "resolucao")
	@NotNull
	private String resolucao;

	@Column(name = "ativo")
	@NotNull
	private boolean ativo;
}
