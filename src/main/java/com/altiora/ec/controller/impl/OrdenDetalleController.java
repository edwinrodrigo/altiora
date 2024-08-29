package com.altiora.ec.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.altiora.ec.controller.IOrdenDetalleController;
import com.altiora.ec.dto.request.OrdenDetalleRequest;
import com.altiora.ec.dto.response.OrdenDetalleResponse;
import com.altiora.ec.entity.OrdenDetalle;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.service.IOrdenDetalleService;
import com.altiora.ec.util.GenericMapperConverterUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrdenDetalleController implements IOrdenDetalleController {

	private final GenericMapperConverterUtils genericConverterUtils;
	private final IOrdenDetalleService ordenDetalleService;
	
	@Override
	public ResponseEntity<OrdenDetalleResponse> create(@Valid OrdenDetalleRequest ordenDetalleRequest) throws CustomErrorResponse{
		OrdenDetalle ordenDetalle = this.genericConverterUtils.convertToEntity(ordenDetalleRequest, OrdenDetalle.class);
		ordenDetalle = ordenDetalleService.save(ordenDetalle);
		OrdenDetalleResponse response = this.genericConverterUtils.convertToDto(ordenDetalle, OrdenDetalleResponse.class); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<List<OrdenDetalleResponse>> getAllOrdenDetalles() throws CustomErrorResponse {
		List<OrdenDetalle> OrdenDetalles = this.ordenDetalleService.findAll();
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(OrdenDetalles, OrdenDetalleResponse.class));
	}

	@Override
	public ResponseEntity<OrdenDetalleResponse> obtieneOrdenDetallePorId(Long id) throws CustomErrorResponse {
		return ResponseEntity.ok().body(this.genericConverterUtils.convertToDto(this.ordenDetalleService.findById(id), OrdenDetalleResponse.class));
	}

	@Override
	public ResponseEntity<OrdenDetalleResponse> actualizaOrdenDetallePorId(OrdenDetalleRequest ordenDetalleRequest)
			throws CustomErrorResponse {
		OrdenDetalle ordenDetalle = this.genericConverterUtils.convertToEntity(ordenDetalleRequest, OrdenDetalle.class);
		ordenDetalle = this.ordenDetalleService.update(ordenDetalle.getIdDetalle(), ordenDetalle);
		OrdenDetalleResponse response = this.genericConverterUtils.convertToDto(ordenDetalle, OrdenDetalleResponse.class); 
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> eliminaOrdenDetallePorId(Long id) throws CustomErrorResponse {
		this.ordenDetalleService.delete(id);
		return ResponseEntity.ok().body(null);
	}

}