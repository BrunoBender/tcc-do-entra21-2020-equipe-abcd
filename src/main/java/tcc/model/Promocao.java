package tcc.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="promocao")
public class Promocao {
	@Column(name="promocao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long promocaoId;

	@Column(name="catalogo_id")
	@NotNull
	private long catalogoId;

	@Column(name="preco_promocional")
	@NotNull
	private double precoPromocional;

	@Column(name="data_inicio")
	@NotNull
	private String dataInicio;

	@Column(name="data_fim")
	@NotNull
	private String dataFim;

	@Column(name="criado_em")
	@NotNull
	private LocalDateTime criadoEm;

	@Column(name="editado_em")
	@NotNull
	private LocalDateTime editadoEm;

	@Column(name="ativo")
	@NotNull
	private boolean ativo;
}
