package com.altiora.ec.dto.response;

import java.time.LocalDateTime;

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
public class OrdenResponse {
	
    private String idOrden;
    private LocalDateTime fecha;
    private Integer total;
    private ClienteResponse cliente;

}
