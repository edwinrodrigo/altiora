package com.altiora.ec.dto.request;

import java.time.LocalDateTime;
import java.util.List;

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
public class OrdenRequest {
	
    private String idOrden;    
    private LocalDateTime fecha;
    private Integer total;
    private ClienteRequest cliente;
    private List<OrdenDetalleRequest> ordenDetalle;

}
