package com.altiora.ec.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ArticuloResponse {

	private Long idArticulo;
	private String nombre;
	private Double precioUnitario;
	private Integer stock;

}
