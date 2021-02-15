package tcc.dto;

import tcc.common.bind.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDTO {
	private Long catalogoId;
	private ComercioDTO comercioId;
	private boolean produto;
	private String categoria;
	private String nomeDescritivo;
	private String marca;
	private String medidaUsada;
	private double quantidadeMedida;
	private double preco;
}
