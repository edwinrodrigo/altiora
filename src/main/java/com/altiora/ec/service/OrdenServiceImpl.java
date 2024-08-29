package com.altiora.ec.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altiora.ec.common.GenericCRUDImpl;
import com.altiora.ec.common.GenericRepository;
import com.altiora.ec.entity.Orden;
import com.altiora.ec.entity.OrdenDetalle;
import com.altiora.ec.repository.IOrdenDetalleRepository;
import com.altiora.ec.repository.IOrdenRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrdenServiceImpl extends  GenericCRUDImpl<Orden, String> implements IOrdenService{

	   private final IOrdenRepository ordenRepository;
	   private final IOrdenDetalleRepository ordenDetalleRepository;

	    @Autowired
	    public OrdenServiceImpl(IOrdenRepository ordenRepository, IOrdenDetalleRepository ordenDetalleRepository) {
	        this.ordenRepository = ordenRepository;
			this.ordenDetalleRepository = ordenDetalleRepository;
	    }

	    @Override
	    protected GenericRepository<Orden, String> getRepository() {
	        return ordenRepository;
	    }
	    
	    @Override
	    @Transactional
		public void guardarOrdenYDetalles(Orden orden) {
	    	
	    	List<OrdenDetalle> detalles = new ArrayList<>(orden.getOrdenDetalle());
	    	orden.getOrdenDetalle().clear();
	    	
	    	Integer lastId = this.ordenRepository.getMaxValueId();
	    	String nextId = generarId(lastId);
	    	orden.setIdOrden(nextId);
	    	orden.setFecha(LocalDateTime.now());
	    	
	    	this.ordenRepository.save(orden);
	    	
	    	for (OrdenDetalle ordenDetalle : detalles) {
	    		ordenDetalle.setIdOrden(orden.getIdOrden());
	    		this.ordenDetalleRepository.save(ordenDetalle);
			}
			
		}
	    
	    private String generarId(Integer id){
    		String cadena = "OC-00000";
	    	Integer numeroOrden = id == null ? 1 : id + 1;
	    	String idOrden = cadena + numeroOrden;
	    	return idOrden;
	    }
	    
	    
	
}
