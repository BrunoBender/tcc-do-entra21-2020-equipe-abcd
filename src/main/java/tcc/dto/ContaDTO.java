package tcc.dto;

import tcc.common.bind.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {
	private Long contaId;
	private String nomeUsuario;
	private String nome;
	private String telefone;
	private String cep;
	private String email;
	private String senha;
}
