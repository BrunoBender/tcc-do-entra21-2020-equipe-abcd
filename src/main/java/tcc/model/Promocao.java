package tcc.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "promocao")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Promocao {
	@Column(name = "promocao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long promocaoId;

	@Column(name = "catalogo_id")
	@NotNull
	private long catalogoId;

	@Column(name = "preco_promocional")
	@NotNull
	private double precoPromocional;

	@Column(name = "data_inicio", length = 15)
	@NotNull
	private String dataInicio;

	@Column(name = "data_fim", length = 15)
	@NotNull
	private String dataFim;

	@Column(name = "criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name = "ativo")
	@NotNull
	private boolean ativo;
}
