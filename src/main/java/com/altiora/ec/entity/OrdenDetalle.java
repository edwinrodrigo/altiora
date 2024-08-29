package com.altiora.ec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orden_detalle")
public class OrdenDetalle {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @Column(name = "id_orden")
    private String idOrden;

    @Column(name = "id_articulo")
    private Long idArticulo;

    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "total")
    private Integer total;


}
