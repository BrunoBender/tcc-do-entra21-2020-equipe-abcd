package tcc.dto;

import tcc.common.bind.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComercioDTO {
	private Long comercioId;
	private ContaDTO contaId;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String logradouro;
	private String numeroEComplemento;
	private String telefone;
	private String cep;
	private String bairro;
	private String cidade;
	private String hashContratoSocial;
}
