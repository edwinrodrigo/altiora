package com.altiora.ec.repository;

import org.springframework.stereotype.Repository;

import com.altiora.ec.common.GenericRepository;
import com.altiora.ec.entity.OrdenDetalle;

@Repository
public interface IOrdenDetalleRepository extends GenericRepository<OrdenDetalle, Long>{

}