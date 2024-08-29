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
public class OrdenDetalleResponse {
	
    private Long idDetalle;
    private String idOrden;
    private Long idArticulo;
    private Integer cantidad;
    private Integer total;

}
