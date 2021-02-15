package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="reporte")
public class Reporte {
	@Column(name="reporte_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long reporteId;

	@Column(name="conta_id")
	@NotNull
	private long contaId;

	@Column(name="comercio_id")
	@NotNull
	private long comercioId;

	@Column(name="data_abertura")
	@NotNull
	private String dataAbertura;

	@Column(name="catalogo")
	@NotNull
	private boolean catalogo;

	@Column(name="promocao")
	@NotNull
	private boolean promocao;

	@Column(name="detalhes")
	@NotNull
	private String detalhes;

	@Column(name="criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name="editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name="data_conclusao")
	@NotNull
	private String dataConclusao;

	@Column(name="resolucao")
	@NotNull
	private String resolucao;

	@Column(name="ativo")
	@NotNull
	private boolean ativo;
}
