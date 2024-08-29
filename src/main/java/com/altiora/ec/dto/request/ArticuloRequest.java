package com.altiora.ec.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
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
public class ArticuloRequest {
	
	private Long idArticulo;

	@NotNull(message = "requerido")
	@Schema(description = "Nombre Articulo", example = "Cuaderno1", type = "string", format = "string", requiredMode = Schema.RequiredMode.REQUIRED)
	private String nombre;
	
	@NotNull(message = "requerido")
	@Schema(description = "Precio Unitario", example = "1.50", type = "double", format = "double", requiredMode = Schema.RequiredMode.REQUIRED)
	private Double precioUnitario;
	
	@NotNull(message = "requerido")
	@Schema(description = "Stock", example = "25", type = "int", format = "int", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer stock;

}