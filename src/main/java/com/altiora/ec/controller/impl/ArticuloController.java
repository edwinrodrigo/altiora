package com.altiora.ec.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.altiora.ec.controller.IArticuloController;
import com.altiora.ec.dto.request.ArticuloRequest;
import com.altiora.ec.dto.response.ArticuloResponse;
import com.altiora.ec.entity.Articulo;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.service.IArticuloService;
import com.altiora.ec.util.GenericMapperConverterUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticuloController implements IArticuloController{

	private final GenericMapperConverterUtils genericConverterUtils;
	private final IArticuloService articuloService;
	
	@Override
	public ResponseEntity<ArticuloResponse> create(ArticuloRequest articuloRequest) throws CustomErrorResponse {
		Articulo articulo = this.genericConverterUtils.convertToEntity(articuloRequest, Articulo.class);
		articulo = articuloService.save(articulo);
		ArticuloResponse response = this.genericConverterUtils.convertToDto(articulo, ArticuloResponse.class); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<List<ArticuloResponse>> getAllArticulos() throws CustomErrorResponse {
		List<Articulo> articulos = this.articuloService.findAll();
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(articulos, ArticuloResponse.class));
	}

	@Override
	public ResponseEntity<ArticuloResponse> obtieneArticuloPorId(Long id) throws CustomErrorResponse {
		return ResponseEntity.ok().body(this.genericConverterUtils.convertToDto(this.articuloService.findById(id), ArticuloResponse.class));
	}

	@Override
	public ResponseEntity<ArticuloResponse> actualizaArticuloPorId(ArticuloRequest articuloRequest) throws CustomErrorResponse {
		Articulo articulo = this.genericConverterUtils.convertToEntity(articuloRequest, Articulo.class);
		articulo = articuloService.update(articulo.getIdArticulo(), articulo);
		ArticuloResponse response = this.genericConverterUtils.convertToDto(articulo, ArticuloResponse.class); 
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> eliminaArticuloPorId(Long id) throws CustomErrorResponse {
		this.articuloService.delete(id);
		return ResponseEntity.ok().body(null);
	}

}