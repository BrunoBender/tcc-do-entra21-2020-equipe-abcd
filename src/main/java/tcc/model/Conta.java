package tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta {
	@Id
	@Column(name = "conta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contaId;

	@Column(name = "nome_usuario", length = 50, nullable = false)
	private String nomeUsuario;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;

	@Column(name = "cep", length = 10, nullable = false)
	private String cep;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Column(name = "senha", length = 30, nullable = false)
	private String senha;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "editado_em")
	private LocalDateTime editadoEm;

	@Column(name = "empreendedor")
	private boolean empreendedor;

	@Column(name = "admin_plataforma")
	private boolean adminPlataforma;

	@Column(name = "ativo")
	private boolean ativo;

	@PrePersist
	public void executaAntesDeInserts() {
		criadoEm = LocalDateTime.now();
		editadoEm = LocalDateTime.now();
		empreendedor = false;
		adminPlataforma = false;
		ativo = true;
	}

	@PreUpdate
	// TODO Esse metodo nao esta impedindo dos campos booleanos de serem atualizados
	public void executaAntesDaAtualizacoes() {
		editadoEm = LocalDateTime.now();
	}
}
