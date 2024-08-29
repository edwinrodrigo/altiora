package com.altiora.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altiora.ec.common.GenericCRUDImpl;
import com.altiora.ec.common.GenericRepository;
import com.altiora.ec.entity.OrdenDetalle;
import com.altiora.ec.repository.IOrdenDetalleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrdenDetalleServiceImpl extends  GenericCRUDImpl<OrdenDetalle, Long> implements IOrdenDetalleService{

	   private final IOrdenDetalleRepository ordenDetalleRepository;

	    @Autowired
	    public OrdenDetalleServiceImpl(IOrdenDetalleRepository ordenDetalleRepository) {
	        this.ordenDetalleRepository = ordenDetalleRepository;
	    }

	    @Override
	    protected GenericRepository<OrdenDetalle, Long> getRepository() {
	        return ordenDetalleRepository;
	    }
	
}
