package com.altiora.ec.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.altiora.ec.controller.IOrdenController;
import com.altiora.ec.dto.request.OrdenRequest;
import com.altiora.ec.dto.response.OrdenResponse;
import com.altiora.ec.entity.Orden;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.service.IOrdenService;
import com.altiora.ec.util.GenericMapperConverterUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrdenController implements IOrdenController {
	
	private final GenericMapperConverterUtils genericConverterUtils;
	private final IOrdenService ordenService;

	@Override
	public ResponseEntity<OrdenResponse> create(@Valid OrdenRequest OrdenRequest) throws CustomErrorResponse {
		Orden orden = this.genericConverterUtils.convertToEntity(OrdenRequest, Orden.class);
		ordenService.guardarOrdenYDetalles(orden);
		return ResponseEntity.ok().body(null);
	}

	@Override
	public ResponseEntity<List<OrdenResponse>> getAllOrdenes() throws CustomErrorResponse {
		List<Orden> Ordens = this.ordenService.findAll();
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(Ordens, OrdenResponse.class));
	}

	@Override
	public ResponseEntity<OrdenResponse> obtieneOrdenPorId(String id) throws CustomErrorResponse {
		return ResponseEntity.ok().body(this.genericConverterUtils.convertToDto(this.ordenService.findById(id), OrdenResponse.class));
	}

	@Override
	public ResponseEntity<OrdenResponse> actualizaOrdenPorId(OrdenRequest OrdenRequest) throws CustomErrorResponse {
		Orden orden = this.genericConverterUtils.convertToEntity(OrdenRequest, Orden.class);
		orden = ordenService.update(orden.getIdOrden(), orden);
		OrdenResponse response = this.genericConverterUtils.convertToDto(orden, OrdenResponse.class); 
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> eliminaOrdenPorId(String id) throws CustomErrorResponse {
		this.ordenService.delete(id);
		return ResponseEntity.ok().body(null);
	}

}
